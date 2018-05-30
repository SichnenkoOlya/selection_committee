package by.sichnenko.committee.controller;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The SessionRequestContent class
 */
public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;
    private Map<String, Part> parts;
    private Set<Cookie> cookiesValues;
    private JSONArray ajaxParameter;

    private boolean needInvalidateSession;
    private String contextPath;
    private String realPath;

    /**
     * Default constructor
     */
    public SessionRequestContent() {
        requestAttributes = new HashMap<>();
        requestParameters = new HashMap<>();
        sessionAttributes = new HashMap<>();
        cookiesValues = new HashSet<>();
    }

    /**
     * Get request attributes
     *
     * @return request attributes
     */
    public HashMap<String, Object> getRequestAttributes() {
        return requestAttributes;
    }

    /**
     * Get request parameters
     *
     * @return request parameters
     */
    public HashMap<String, String[]> getRequestParameters() {
        return requestParameters;
    }

    /**
     * Get session attributes
     *
     * @return session attributes
     */
    public HashMap<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }

    /**
     * Get context path
     *
     * @return context path
     */
    public String getContextPath() {
        return contextPath;
    }

    /**
     * Get real path
     *
     * @return real path
     */
    public String getRealPath() {
        return realPath;
    }

    /**
     * Get ajax parameter
     *
     * @return ajax parameter
     */
    public JSONArray getAjaxParameter() {
        return ajaxParameter;
    }

    /**
     * Set ajax parameter
     *
     * @param ajaxParameter ajax parameter
     */
    public void setAjaxParameter(JSONArray ajaxParameter) {
        this.ajaxParameter = ajaxParameter;
    }

    /**
     * Get parts of request
     *
     * @return parts
     */
    public Map<String, Part> getParts() {
        return parts;
    }

    /**
     * Set parts
     *
     * @param parts parts
     */
    public void setParts(Map<String, Part> parts) {
        this.parts = parts;
    }

    /**
     * Set boolean value if need to invalidate current session
     *
     * @param needInvalidateSession boolean value, true if we need to invalidate current session, else false
     */
    public void setNeedInvalidateSession(boolean needInvalidateSession) {
        this.needInvalidateSession = needInvalidateSession;
    }

    /**
     * Get cookies values
     *
     * @return cookies values
     */
    public Set<Cookie> getCookiesValues() {
        return cookiesValues;
    }

    /**
     * Fills the this object with the current values of request
     *
     * @param request HttpServletRequest
     * @throws ServletException the Servlet exception
     * @throws IOException      the IO exception
     */
    void extractValues(HttpServletRequest request) throws IOException, ServletException {
        Enumeration<String> attributteNames = request.getAttributeNames();
        Enumeration<String> parameterNames = request.getParameterNames();
        Enumeration<String> sessionAttrNameibutteNames = request.getSession().getAttributeNames();

        while (attributteNames.hasMoreElements()) {
            String attributteName = attributteNames.nextElement();
            requestAttributes.put(attributteName, request.getAttribute(attributteName));
        }

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            requestParameters.put(paramName, request.getParameterValues(paramName));
        }

        while (sessionAttrNameibutteNames.hasMoreElements()) {
            String sessionAttrName = sessionAttrNameibutteNames.nextElement();
            sessionAttributes.put(sessionAttrName, request.getSession().getAttribute(sessionAttrName));
        }

        if (request.getContentType() != null && request.getContentType().toLowerCase().contains("multipart/form-data")) {
            parts = request.getParts().stream()
                    .collect(Collectors.toMap(Part::getName, x -> x));
        }
        contextPath = request.getContextPath();
        realPath = request.getServletContext().getRealPath("");
    }

    /**
     * Insert into request the values of SessionRequestContent object
     *
     * @param request HttpServletRequest
     */
    void insertAttributes(HttpServletRequest request) {

        Enumeration<String> sessionAttrNameibutteNames = request.getSession().getAttributeNames();
        Enumeration<String> attributteNames = request.getAttributeNames();
        Enumeration<String> parameterNames = request.getParameterNames();

        if (!needInvalidateSession) {
            while (sessionAttrNameibutteNames.hasMoreElements()) {
                String sessionAttrName = sessionAttrNameibutteNames.nextElement();
                request.getSession().removeAttribute(sessionAttrName);
                sessionAttributes.forEach((key, value) -> request.getSession().setAttribute(key, value));
            }
        } else {
            request.getSession().invalidate();
        }

        while (attributteNames.hasMoreElements()) {
            String attributteName = attributteNames.nextElement();
            request.removeAttribute(attributteName);
        }

        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            request.removeAttribute(parameterName);
        }

        requestAttributes.forEach(request::setAttribute);
        contextPath = request.getContextPath();
        realPath = request.getServletContext().getRealPath("");
    }
}

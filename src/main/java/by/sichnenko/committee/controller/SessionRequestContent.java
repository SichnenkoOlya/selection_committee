package by.sichnenko.committee.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;
    private Map<String,Part> parts;
    private ServletContext servletContext;
    private JSONArray ajaxParameter;

    private String contextPath;
    private String realPath;

    public SessionRequestContent() {
        requestAttributes = new HashMap<>();
        requestParameters = new HashMap<>();
        sessionAttributes = new HashMap<>();
    }

    public HashMap<String, Object> getRequestAttributes() {
        return requestAttributes;
    }

    public HashMap<String, String[]> getRequestParameters() {
        return requestParameters;
    }

    public HashMap<String, Object> getSessionAttributes() {
        return sessionAttributes;
    }

    public String getContextPath() {
        return contextPath;
    }

    public String getRealPath() {
        return realPath;
    }

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
        servletContext=request.getServletContext();
        if (request.getContentType() != null && request.getContentType().toLowerCase().contains("multipart/form-data")) {
            parts = request.getParts().stream()
                    .collect(Collectors.toMap(Part::getName, x -> x));
        }
        contextPath = request.getContextPath();
        realPath = request.getServletContext().getRealPath("");
    }


    void insertAttributes(HttpServletRequest request) {
        Enumeration<String> sessionAttrNameibutteNames = request.getSession().getAttributeNames();
        Enumeration<String> attributteNames = request.getAttributeNames();

        while (sessionAttrNameibutteNames.hasMoreElements()) {
            String sessionAttrName = sessionAttrNameibutteNames.nextElement();
            request.getSession().removeAttribute(sessionAttrName);
        }

        while (attributteNames.hasMoreElements()) {
            String attributteName = attributteNames.nextElement();
            request.removeAttribute(attributteName);
        }

        requestAttributes.forEach(request::setAttribute);
        sessionAttributes.forEach((key, value) -> request.getSession().setAttribute(key, value));
        contextPath = request.getContextPath();
        realPath = request.getServletContext().getRealPath("");
    }

    public JSONArray getAjaxParameter() {
        return ajaxParameter;
    }

    public void setAjaxParameter(JSONArray ajaxParameter) {
        this.ajaxParameter = ajaxParameter;
    }

    public Map<String, Part> getParts() {
        return parts;
    }

    public void setParts(Map<String, Part> parts) {
        this.parts = parts;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}

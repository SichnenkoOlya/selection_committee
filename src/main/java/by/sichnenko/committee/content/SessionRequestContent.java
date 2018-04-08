package by.sichnenko.committee.content;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;
    private String contextPath;
    private String realPath;

    public SessionRequestContent(){
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
    
    public void extractValues(HttpServletRequest request) {
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
    }


    public void insertAttributes(HttpServletRequest request) {
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
}

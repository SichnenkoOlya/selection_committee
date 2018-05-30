package by.sichnenko.committee.filter;

import by.sichnenko.committee.util.URIAnalyzer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.sichnenko.committee.constant.RequestNameConstant.CURRENT_QUERY;
import static by.sichnenko.committee.constant.RequestNameConstant.LAST_QUERY;

@WebFilter(filterName = "CurrentPageFilter", urlPatterns = {"/pages/*", "/mainController"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class CurrentPageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = URIAnalyzer.cleanURI(request.getRequestURI().substring(request.getContextPath().length()));
        if (!URIAnalyzer.isPageURI(uri)) {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            session.setAttribute(LAST_QUERY, session.getAttribute(CURRENT_QUERY));
            if (((HttpServletRequest) servletRequest).getQueryString() != null) {
                session.setAttribute(CURRENT_QUERY, ((HttpServletRequest) servletRequest).getRequestURI() + "?" + ((HttpServletRequest) servletRequest).getQueryString());
            } else {
                session.setAttribute(CURRENT_QUERY, ((HttpServletRequest) servletRequest).getRequestURI());
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
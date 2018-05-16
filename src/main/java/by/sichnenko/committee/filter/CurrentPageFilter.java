package by.sichnenko.committee.filter;

import by.sichnenko.committee.util.URIAnalyzer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CurrentPageFilter", urlPatterns = {"/pages/*","/mainController"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class CurrentPageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig){

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = URIAnalyzer.cleanURI(request.getRequestURI().substring(request.getContextPath().length()));
        if (URIAnalyzer.isPageURI(uri)) {
            ((HttpServletRequest) servletRequest).getSession().setAttribute("lastPage", uri);
        }else {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            String s1 = ((HttpServletRequest) servletRequest).getRequestURI();
            String s2 = ((HttpServletRequest) servletRequest).getQueryString();
            session.setAttribute("lastQuery",session.getAttribute("currentQuery"));
            session.setAttribute("currentQuery", ((HttpServletRequest) servletRequest).getRequestURI() + "?" + ((HttpServletRequest) servletRequest).getQueryString());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
package by.sichnenko.committee.filter;

import by.sichnenko.committee.util.URIAnalyzer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "CurrentPageFilter", urlPatterns = {"/pages/*"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
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
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
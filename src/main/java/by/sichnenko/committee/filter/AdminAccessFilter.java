package by.sichnenko.committee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminAccessFilter", urlPatterns = "/pages/admin???/*",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class AdminAccessFilter implements Filter {
    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //???
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}

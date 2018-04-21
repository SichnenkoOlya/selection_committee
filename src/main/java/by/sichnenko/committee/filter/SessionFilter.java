package by.sichnenko.committee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SessionFilter", urlPatterns = {"/pages/*"},
        dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class SessionFilter implements Filter {
    private static final int SESSION_LIFE_TIME = 2000 * 60;

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
/*
        if (session.isNew()) {
            session.setMaxInactiveInterval(SESSION_LIFE_TIME);
        }

        if (session.getAttribute(SESSION) == null) {
            session.setAttribute(SESSION, true);
            httpResponse.sendRedirect(PageNameConstant.INDEX_PAGE);
            return;
        }*/
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}

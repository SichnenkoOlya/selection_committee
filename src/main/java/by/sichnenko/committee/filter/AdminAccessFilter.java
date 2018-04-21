package by.sichnenko.committee.filter;

import by.sichnenko.committee.constant.PageNameConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.validator.UserValidator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminAccessFilter", urlPatterns = "/pages/admin/*",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class AdminAccessFilter implements Filter {
    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

    /*    User user = (User) httpRequest.getSession().getAttribute(RequestNameConstant.USER);

        if (!UserValidator.isAdmin(user)) {
            httpResponse.sendRedirect(PageNameConstant.INDEX_PAGE);
            return;
        }*/

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}

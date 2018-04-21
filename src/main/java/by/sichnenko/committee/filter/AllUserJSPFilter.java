package by.sichnenko.committee.filter;

import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Subject;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.SubjectService;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.SubjectServiceImpl;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.sichnenko.committee.constant.RequestNameConstant.SUBJECTS;
import static by.sichnenko.committee.constant.RequestNameConstant.USERS;

@WebFilter(filterName = "AllUserJSPFilter", urlPatterns = {"/pages/admin/all_users.jsp"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class AllUserJSPFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(MainJSPFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UserService userService = new UserServiceImpl();
        try {
            List<User> users = userService.findAllUsers();
            servletRequest.setAttribute(USERS, users);
        } catch (ServiceException e) {
            LOGGER.error("Error loading users ", e);
            ((HttpServletResponse)servletResponse).sendError(404);
            //servletRequest.setAttribute(ERROR_LOADING_FACULTIES, true);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
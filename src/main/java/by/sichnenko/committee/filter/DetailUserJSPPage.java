package by.sichnenko.committee.filter;

import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Subject;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.service.SubjectService;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.EnrolleeServiceImpl;
import by.sichnenko.committee.service.impl.SubjectServiceImpl;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.sichnenko.committee.constant.RequestNameConstant.ENROLLEE;
import static by.sichnenko.committee.constant.RequestNameConstant.SUBJECTS;
import static by.sichnenko.committee.constant.RequestNameConstant.USER;

@WebFilter(filterName = "DetailUserJSPPage", urlPatterns = {"/pages/admin/detail_user.jsp"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class DetailUserJSPPage implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(MainJSPFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UserService userService = new UserServiceImpl();
        EnrolleeService enrolleeService = new EnrolleeServiceImpl();

        try {
            String login = servletRequest.getParameter(RequestNameConstant.LOGIN);
            User user = userService.findUser(login);

            Enrollee enrollee = enrolleeService.findEnrolleeByUser(login);
            servletRequest.setAttribute(USER, user);
            servletRequest.setAttribute(ENROLLEE, enrollee);
        } catch (ServiceException e) {
            LOGGER.error("Error loading subjects ", e);
            ((HttpServletResponse) servletResponse).sendError(404);
            //servletRequest.setAttribute(ERROR_LOADING_FACULTIES, true);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
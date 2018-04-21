package by.sichnenko.committee.filter;

import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Subject;
import by.sichnenko.committee.service.SubjectService;
import by.sichnenko.committee.service.impl.SubjectServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.sichnenko.committee.constant.RequestNameConstant.SUBJECTS;

@WebFilter(filterName = "AddFacultyJSPFilter", urlPatterns = {"/pages/add_faculty.jsp"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class AddFacultyJSPFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(MainJSPFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SubjectService subjectService = new SubjectServiceImpl();
        try {
            List<Subject> subjects = subjectService.findAllSubjects();
            servletRequest.setAttribute(SUBJECTS, subjects);
        } catch (ServiceException e) {
            LOGGER.error("Error loading subjects ", e);
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

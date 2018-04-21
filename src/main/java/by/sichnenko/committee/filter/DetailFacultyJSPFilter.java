package by.sichnenko.committee.filter;

import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.sichnenko.committee.constant.RequestNameConstant.FACULTY;

@WebFilter(filterName = "DetailFacultyJSPFilter", urlPatterns = {"/pages/faculty_detail.jsp"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class DetailFacultyJSPFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(MainJSPFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        FacultyService facultyService = new FacultyServiceImpl();

        try {
            String facultyId = servletRequest.getParameter(RequestNameConstant.FACULTY_ID);
            Faculty faculty = facultyService.findFacultyById(facultyId);
            servletRequest.setAttribute(FACULTY, faculty);

        } catch (ServiceException e) {
            LOGGER.error("Error loading faculty ", e);
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
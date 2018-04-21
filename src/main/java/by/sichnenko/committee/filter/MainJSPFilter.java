package by.sichnenko.committee.filter;

import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

import static by.sichnenko.committee.constant.ErrorConstant.ERROR_LOADING_FACULTIES;
import static by.sichnenko.committee.constant.RequestNameConstant.FACULTIES;

@WebFilter(filterName = "MainJSPFilter", urlPatterns = {"/pages/main.jsp"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class MainJSPFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(MainJSPFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        FacultyService facultyService = new FacultyServiceImpl();
        try {
            List<Faculty> faculties = facultyService.findAllFaculties();
            servletRequest.setAttribute(FACULTIES, faculties);
        } catch (ServiceException e) {
            //((HttpServletResponse)servletResponse).sendError(404);
            servletRequest.setAttribute(ERROR_LOADING_FACULTIES, true);
            LOGGER.error("Error loading faculties ", e);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
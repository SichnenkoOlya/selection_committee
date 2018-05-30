package by.sichnenko.committee.filter;

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
import java.util.List;

import static by.sichnenko.committee.constant.RequestNameConstant.FACULTIES;

@WebFilter(filterName = "MainJSPFilter", urlPatterns = {"/pages/common/main.jsp"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
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
            LOGGER.error("Error loading faculties ", e);
            ((HttpServletResponse) servletResponse).sendError(500);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
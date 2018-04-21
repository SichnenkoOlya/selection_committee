package by.sichnenko.committee.filter;

import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.*;
import by.sichnenko.committee.service.*;
import by.sichnenko.committee.service.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.sichnenko.committee.constant.RequestNameConstant.*;

@WebFilter(filterName = "EnrolleeFillJSPFilter", urlPatterns = {"/pages/enrollee_fill.jsp"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class EnrolleeFillJSPFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(MainJSPFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CountryService countryService = new CountryServiceImpl();
        PrivilegeService privilegeService = new PrivilegeServiceImpl();
        SubjectService subjectService = new SubjectServiceImpl();
        FacultyService facultyService = new FacultyServiceImpl();
        CityService cityService = new CityServiceImpl();

        try {
            List<Country> countries = countryService.findAllCountries();
            servletRequest.setAttribute(COUNTRIES, countries);

            List<City> cities = cityService.findAllCities();
            servletRequest.setAttribute(CITIES, cities);

            List<Subject> subjects = subjectService.findAllSubjects();
            servletRequest.setAttribute(SUBJECTS, subjects);

            List<Privilege> privileges = privilegeService.findAllPrivileges();
            servletRequest.setAttribute(PRIVILEGES, privileges);

            List<Faculty> faculties = facultyService.findAllFaculties();
            servletRequest.setAttribute(FACULTIES, faculties);

        } catch (ServiceException e) {
            LOGGER.error("Error loading page ", e);
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
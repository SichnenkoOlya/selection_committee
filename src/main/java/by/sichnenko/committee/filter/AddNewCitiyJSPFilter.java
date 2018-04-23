package by.sichnenko.committee.filter;

import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Country;
import by.sichnenko.committee.service.*;
import by.sichnenko.committee.service.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.sichnenko.committee.constant.RequestNameConstant.COUNTRIES;

@WebFilter(filterName = "AddNewCitiyJSPFilter", urlPatterns = {"/pages/admin/add_city.jsp"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class AddNewCitiyJSPFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(MainJSPFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CountryService countryService = new CountryServiceImpl();

        try {
            List<Country> countries = countryService.findAllCountries();
            servletRequest.setAttribute(COUNTRIES, countries);

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
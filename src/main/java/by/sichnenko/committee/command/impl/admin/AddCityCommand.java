package by.sichnenko.committee.command.impl.admin;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Country;
import by.sichnenko.committee.service.CityService;
import by.sichnenko.committee.service.CountryService;
import by.sichnenko.committee.service.impl.CityServiceImpl;
import by.sichnenko.committee.service.impl.CountryServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.ADD_CITY_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.COUNTRIES;

/**
 * The AddCityCommand class
 */
public class AddCityCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(AddCityCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        CityService cityService = new CityServiceImpl();
        CountryService countryService = new CountryServiceImpl();
        List<Country> countries = new ArrayList<>();
        try {
            countries = countryService.findAllCountries();
            cityService.addCity(sessionRequestContent);
        } catch (ServiceException e) {
            LOGGER.catching(e);
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA) ||
                    keys.contains(GeneralConstant.CITY_EXIST)) {
                sessionRequestContent.getRequestAttributes().put(COUNTRIES, countries);
                return new Router(RouterType.FORWARD, ADD_CITY_PAGE);
            }
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.REDIRECT, ADD_CITY_PAGE);
    }
}

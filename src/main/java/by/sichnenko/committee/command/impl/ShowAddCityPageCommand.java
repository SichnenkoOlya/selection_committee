package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Country;
import by.sichnenko.committee.service.CountryService;
import by.sichnenko.committee.service.impl.CountryServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.util.List;

import static by.sichnenko.committee.constant.PageNameConstant.ADD_CITY_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.COUNTRIES;

public class ShowAddCityPageCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        CountryService countryService = new CountryServiceImpl();

        try {
            List<Country> countries = countryService.findAllCountries();
            sessionRequestContent.getRequestAttributes().put(COUNTRIES, countries);

        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, ADD_CITY_PAGE);
        }
        return new Router(RouterType.FORWARD, ADD_CITY_PAGE);
    }
}

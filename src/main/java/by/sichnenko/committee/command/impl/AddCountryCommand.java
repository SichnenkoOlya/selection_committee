package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.service.CountryService;
import by.sichnenko.committee.service.impl.CountryServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.ADD_CITY_PAGE;
import static by.sichnenko.committee.constant.PageNameConstant.ADD_COUNTRY_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.COUNTRIES;

public class AddCountryCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        CountryService countryService = new CountryServiceImpl();
        try {
            countryService.addCountry(sessionRequestContent);
        } catch (ServiceException e) {
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA) ||
                    keys.contains(GeneralConstant.COUNTRY_EXIST)) {
                return new Router(RouterType.FORWARD, ADD_COUNTRY_PAGE);
            }
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.REDIRECT, ADD_COUNTRY_PAGE);
    }
}
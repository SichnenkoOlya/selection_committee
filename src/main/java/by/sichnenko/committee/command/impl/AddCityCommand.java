package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.service.CityService;
import by.sichnenko.committee.service.impl.CityServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.ADD_CITY_PAGE;

public class AddCityCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        CityService cityService = new CityServiceImpl();
        try {
            cityService.addCity(sessionRequestContent);
        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, ADD_CITY_PAGE);
        }
        return new Router(RouterType.REDIRECT, ADD_CITY_PAGE);
    }
}

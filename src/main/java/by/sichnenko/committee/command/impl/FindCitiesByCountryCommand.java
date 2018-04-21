package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.service.CityService;
import by.sichnenko.committee.service.impl.CityServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

public class FindCitiesByCountryCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        CityService cityService = new CityServiceImpl();
        try {
            cityService.findCitiesByCountryId(sessionRequestContent);
        } catch (ServiceException e) {
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.AJAX);
    }
}

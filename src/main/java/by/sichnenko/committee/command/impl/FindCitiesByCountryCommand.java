package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.City;
import by.sichnenko.committee.service.CityService;
import by.sichnenko.committee.service.impl.CityServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import net.sf.json.JSONArray;

import java.util.List;

public class FindCitiesByCountryCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        CityService cityService = new CityServiceImpl();
        try {
            List<City> cities = cityService.findCitiesByCountryId(sessionRequestContent);
            sessionRequestContent.setAjaxParameter(JSONArray.fromObject(cities));
        } catch (ServiceException e) {
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.AJAX);
    }
}

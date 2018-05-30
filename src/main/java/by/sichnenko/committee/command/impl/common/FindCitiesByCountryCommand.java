package by.sichnenko.committee.command.impl.common;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.command.impl.admin.AddCityCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.City;
import by.sichnenko.committee.service.CityService;
import by.sichnenko.committee.service.impl.CityServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import net.sf.json.JSONArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.ADD_CITY_PAGE;

/**
 * The FindCitiesByCountryCommand class
 */
public class FindCitiesByCountryCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(FindCitiesByCountryCommand.class);
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        CityService cityService = new CityServiceImpl();
        try {
            List<City> cities = cityService.findCitiesByCountryId(sessionRequestContent);
            sessionRequestContent.setAjaxParameter(JSONArray.fromObject(cities));
        } catch (ServiceException e) {
            LOGGER.catching(e);
            sessionRequestContent.setAjaxParameter(JSONArray.fromObject(null));
        }
        return new Router(RouterType.AJAX);
    }
}

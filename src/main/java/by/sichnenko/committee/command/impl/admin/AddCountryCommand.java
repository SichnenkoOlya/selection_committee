package by.sichnenko.committee.command.impl.admin;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.service.CountryService;
import by.sichnenko.committee.service.impl.CountryServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.ADD_COUNTRY_PAGE;

/**
 * The AddCountryCommand class
 */
public class AddCountryCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(AddCountryCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        CountryService countryService = new CountryServiceImpl();
        try {
            countryService.addCountry(sessionRequestContent);
        } catch (ServiceException e) {
            LOGGER.catching(e);
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
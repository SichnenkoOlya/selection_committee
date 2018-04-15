package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.*;
import by.sichnenko.committee.service.*;
import by.sichnenko.committee.service.impl.*;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.util.List;
import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.FILL_ENROLLEE_PAGE;

public class ShowEnrolleeFillPage implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        CountryService countryService = new CountryServiceImpl();
        PrivilegeService privilegeService = new PrivilegeServiceImpl();
        SubjectService subjectService = new SubjectServiceImpl();
        FacultyService facultyService = new FacultyServiceImpl();
        CityService cityService = new CityServiceImpl();

        try {
            List<Country> countries = countryService.findAllCountries(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put("countries", countries);

            List<Subject> subjects = subjectService.findAllSubjects(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put("subjects", subjects);

            List<Privilege> privileges = privilegeService.findAllPrivileges(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put("privileges", privileges);

            List<Faculty> faculties = facultyService.findAllFaculties(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put("faculties", faculties);

            List<City> cities = cityService.findAllCities(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put("cities", cities);

        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, FILL_ENROLLEE_PAGE);
        }
        return new Router(RouterType.FORWARD, FILL_ENROLLEE_PAGE);
    }
}

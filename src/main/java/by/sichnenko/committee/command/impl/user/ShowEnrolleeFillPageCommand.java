package by.sichnenko.committee.command.impl.user;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.*;
import by.sichnenko.committee.service.*;
import by.sichnenko.committee.service.impl.*;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.FILL_ENROLLEE_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.*;

/**
 * The ShowEnrolleeFillPageCommand class
 */
public class ShowEnrolleeFillPageCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ShowEnrolleeFillPageCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        CountryService countryService = new CountryServiceImpl();
        PrivilegeService privilegeService = new PrivilegeServiceImpl();
        SubjectService subjectService = new SubjectServiceImpl();
        FacultyService facultyService = new FacultyServiceImpl();
        CityService cityService = new CityServiceImpl();

        try {
            List<Country> countries = countryService.findAllCountries();
            sessionRequestContent.getRequestAttributes().put(COUNTRIES, countries);

            List<Subject> subjects = subjectService.findAllSubjects();
            sessionRequestContent.getRequestAttributes().put(SUBJECTS, subjects);

            List<Privilege> privileges = privilegeService.findAllPrivileges();
            sessionRequestContent.getRequestAttributes().put(PRIVILEGES, privileges);

            List<Faculty> faculties = facultyService.findAllAvaliableFaculties();

            if (sessionRequestContent.getSessionAttributes().containsKey(ENROLLEE)) {
                Enrollee enrollee = (Enrollee) sessionRequestContent.getSessionAttributes().get(ENROLLEE);
                Long facultyId = enrollee.getFacultyId();
                sessionRequestContent.getRequestParameters().put(FACULTY_ID, new String[]{String.valueOf(facultyId)});
                Faculty faculty = facultyService.findFacultyById(sessionRequestContent);
                if (!faculties.contains(faculty)) {
                    faculties.add(faculty);
                }
            }

            sessionRequestContent.getRequestAttributes().put(FACULTIES, faculties);

            List<City> cities = cityService.findAllCities();
            sessionRequestContent.getRequestAttributes().put(CITIES, cities);

        } catch (ServiceException e) {
            LOGGER.catching(e);
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA)) {
                return new Router(RouterType.FORWARD, FILL_ENROLLEE_PAGE);
            }
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.FORWARD, FILL_ENROLLEE_PAGE);
    }
}

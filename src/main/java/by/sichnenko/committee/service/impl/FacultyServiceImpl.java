package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.FacultyDAO;
import by.sichnenko.committee.dao.SubjectDAO;
import by.sichnenko.committee.dao.impl.FacultyDAOImpl;
import by.sichnenko.committee.dao.impl.SubjectDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.util.ImageUploader;
import by.sichnenko.committee.validator.GeneralValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.sichnenko.committee.constant.GeneralConstant.DIRECTORY_FACULTY;
import static by.sichnenko.committee.constant.RequestNameConstant.IMAGE;


public class FacultyServiceImpl implements FacultyService {
    @Override
    public List<Faculty> findAllFaculties(SessionRequestContent sessionRequestContent) throws ServiceException {
        FacultyDAO facultyDAO;
        try {
            facultyDAO = new FacultyDAOImpl();
            return facultyDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Sorry, technical error", e);
        }
    }

    @Override
    public Faculty findFacultyById(SessionRequestContent sessionRequestContent) throws ServiceException {
        FacultyDAO facultyDAO;
        SubjectDAO subjectDAO;
        String[] facultyId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.FACULTY_ID);
        if (GeneralValidator.isVarExist(facultyId)) {
            try {
                facultyDAO = new FacultyDAOImpl();
                subjectDAO = new SubjectDAOImpl();
                Faculty faculty = facultyDAO.findFacultyById(Long.valueOf(facultyId[0]));
                faculty.setSubjects(subjectDAO.findSubjetsForFaculty(Long.valueOf(facultyId[0])));
                return faculty;
            } catch (DAOException e) {
                throw new ServiceException("Sorry, technical error", e);
            }
        }
        throw new ServiceException("Sorry, technical error");
    }

    @Override
    public void addFaculty(SessionRequestContent sessionRequestContent) throws ServiceException {
        FacultyDAO facultyDAO;
        SubjectDAO subjectDAO;

        String[] facultyName = sessionRequestContent.getRequestParameters().get(RequestNameConstant.FACULTY_NAME);
        String[] description = sessionRequestContent.getRequestParameters().get(RequestNameConstant.FACULTY_DESCRIPTION);
        // String[] paidScore = sessionRequestContent.getRequestParameters().get(RequestNameConstant.PAID_SCORE);
        //String[] budjetScore = sessionRequestContent.getRequestParameters().get(RequestNameConstant.BUDJET_SCORE);
        String[] paidCount = sessionRequestContent.getRequestParameters().get(RequestNameConstant.PAID_COUNT);
        String[] budjetCount = sessionRequestContent.getRequestParameters().get(RequestNameConstant.BUDJET_COUNT);
        String[] subjects = sessionRequestContent.getRequestParameters().get(RequestNameConstant.SUBJECT_ID);

        if (GeneralValidator.isVarExist(facultyName) && GeneralValidator.isVarExist(description) &&
                GeneralValidator.isVarExist(paidCount) &&
                GeneralValidator.isVarExist(budjetCount) &&
                GeneralValidator.isVarExist(subjects)) {
            try {
                facultyDAO = new FacultyDAOImpl();
                subjectDAO = new SubjectDAOImpl();
                Faculty faculty = new Faculty();
                faculty.setName(facultyName[0]);
                faculty.setDescription(description[0]);
                faculty.setPaidPlaceCount(Integer.valueOf(paidCount[0]));
                faculty.setBudjetPlaceCount(Integer.valueOf(budjetCount[0]));
                facultyDAO.create(faculty);
                Faculty findFaculty = facultyDAO.findFacultyByName(facultyName[0]);
                List<Long> subjectsId=new ArrayList<>();
                for(String subjetcId:subjects){
                    subjectsId.add(Long.valueOf(subjetcId));
                }

                subjectDAO.addSubjectsForFaculty(findFaculty.getFacultyId(), subjectsId);
                return;
            } catch (DAOException e) {
                throw new ServiceException("Sorry, technical error", e);
            }
        }
        throw new ServiceException("Sorry, technical error");
    }


    @Override
    public boolean loadImage(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] facultyId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.FACULTY_ID);
        if (GeneralValidator.isVarExist(facultyId)) {
            ImageUploader fileUploader = new ImageUploader();
            Optional<String> filePath=fileUploader.loadFile(sessionRequestContent, IMAGE, DIRECTORY_FACULTY, facultyId[0]);
            if(filePath.isPresent()){
            FacultyDAO facultyDAO=new FacultyDAOImpl();
                try {
                    facultyDAO.upfdateImage(Long.valueOf(facultyId[0]),filePath.get());
                    return true;
                } catch (DAOException e) {

                    return false;
                }}

        }
        return false;
    }
}

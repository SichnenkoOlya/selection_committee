package by.sichnenko.committee.controller;

import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.util.ExcelGeneratorService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/mainController"})
public class MainController extends AbstractController {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
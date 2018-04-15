package by.sichnenko.committee.controller;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.command.ActionFactory;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet(name = "MainController", urlPatterns = {"/mainController"})
public class MainController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        SessionRequestContent sessionRequestContent = new SessionRequestContent();
        sessionRequestContent.extractValues(request);
        Router router = command.execute(sessionRequestContent);
        sessionRequestContent.insertAttributes(request);
        if (RouterType.FORWARD.equals(router.getRouterType())) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(router.getRouterPage());
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(router.getRouterPage());
        }
    }
}
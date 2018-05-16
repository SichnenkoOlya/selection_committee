package by.sichnenko.committee.controller;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.command.ActionFactory;
import by.sichnenko.committee.util.Router;
import net.sf.json.JSONArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

abstract class AbstractController extends HttpServlet {

    void processRequest(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        SessionRequestContent sessionRequestContent = new SessionRequestContent();
        sessionRequestContent.extractValues(request);
        Router router = command.execute(sessionRequestContent);
        for (Cookie cookie : sessionRequestContent.getCookiesValues()) {
            response.addCookie(cookie);
        }
        sessionRequestContent.insertAttributes(request);

        switch (router.getRouterType()) {
            case FORWARD:
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(router.getRouterPage());
                dispatcher.forward(request, response);
                break;
            case REDIRECT:
                response.sendRedirect(router.getRouterPage());
                break;
            case ERROR:
                response.sendError(500);
                break;
            case AJAX:
                JSONArray jsonArray = sessionRequestContent.getAjaxParameter();
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.println(jsonArray);
                break;
            default:
                response.sendError(404);
        }
    }
}

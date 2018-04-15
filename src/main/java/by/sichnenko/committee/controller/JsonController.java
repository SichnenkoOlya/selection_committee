package by.sichnenko.committee.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import net.sf.json.JSONArray;

@WebServlet(name = "JsonController", urlPatterns = {"/jsonController"})
public class JsonController extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException,IOException {
        JSONArray arrayObj=new JSONArray();
        arrayObj.add("D");
        arrayObj.add("A");
        arrayObj.add("L");
        arrayObj.add("D");
        arrayObj.add("A");
        arrayObj.add("TEST");
        PrintWriter out = response.getWriter();
        out.println(arrayObj);
        for(int i=0;i<arrayObj.size();i++){
            out.println(arrayObj.getString(i));
        }
    }
}
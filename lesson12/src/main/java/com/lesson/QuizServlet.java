package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/mainquiz")
public class QuizServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/mainquiz.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String choice = req.getParameter("choose");

        switch (choice) {
            case "history":
                resp.sendRedirect("historyquiz");
                break;
            case "sport":
                resp.sendRedirect("sportquiz");
                break;
            case "space":
                resp.sendRedirect("spacequiz");
                break;
            default:
                break;
        }
    }

}

package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@WebServlet("/timer")
public class TimerServlet extends HttpServlet
{
    private int time = 0;
    private Timer timer;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/timer.jsp").forward(req, resp);
    }
}

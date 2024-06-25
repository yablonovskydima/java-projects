package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/mult")
public class MultiplicationServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("""
                <form>
                 <label for="inum">Input a number: </label>
                 <input type="text" id="inum" name="inum"><br>
                </form>
                """);
        String val = req.getParameter("inum");
        int num = Integer.parseInt(val);
        resp.setContentType("text/html");
        for (int i = 1; i < 10; i++)
        {
            resp.getWriter().println("<h5>" + num +" * " + i + " = " + (num*i) + "</h5>");
        }

    }

}

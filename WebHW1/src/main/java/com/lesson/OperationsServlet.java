package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/operations")
public class OperationsServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        resp.getWriter().println("""
                <h1>Operations</h1>
                <form>
                    <label for='num1'>Input first number</label>
                    <input type='text' id='num1' name='num1'><br>
                    <label for='num2'>Input second number</label>
                    <input type='text' id='num2' name='num2'><br>
                    <label for='num3'>Input third number</label>
                    <input type='text' id='num3' name='num3'><br>
                    <input type='radio' name='choice' value='Max'>Max<br>
                    <input type='radio' name='choice' value='Min'>Min<br>
                    <input type='radio' name='choice' value='Average'>Average<br>
                    <input type='submit' value='Go'>
                </form>
                """);
        String choice = req.getParameter("choice");
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int num3 = Integer.parseInt(req.getParameter("num3"));
        int res = 0;

        if(choice.equals("Max"))
        {
            res = Math.max(num1, Math.max(num2, num3));
        } else if (choice.equals("Min")) {
            res = Math.min(num1, Math.min(num2, num3));
        }
        else if (choice.equals("Average")) {
            res = (num1+num2+num3)/3;
        }

        resp.getWriter().println("""
                <h1>%s = %d</h1>
                <h3>num1 = %d</h3>
                <h3>num2 = %d</h3>
                <h3>num3 = %d</h3>
                """.formatted(choice, res, num1, num2, num3));
    }
}

package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        resp.getWriter().println("""
                <h1>Calculator</h1>
                <form>
                    <label>Input first number</label><br>
                    <input type='text' name='num1'><br>
                    <label>Input first number</label><br>
                    <input type='text' name='num2'><br>
                    <input type='radio' name='operate' value='add'>Addition<input type='radio' name='operate' value='sub'>Subtraction<input type='radio' name='operate' value='mult'>Multiplication<br>
                    <input type='radio' name='operate' value='div'>Division<input type='radio' name='operate' value='pow'>Power<input type='radio' name='operate' value='perc'>Percentage<br>
                    <input type='submit' value='Go'>
                </from>
                """);

        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String option = req.getParameter("operate");
        double res = 0;

        switch (option)
        {
            case "add":
                res = num1+num2;
                break;
            case "sub":
                res = num1-num2;
                break;
            case "mult":
                res = num1*num2;
                break;
            case "div":
                if(num2 != 0)
                    res = num1/num2;
                break;
            case "pow":
                res = Math.pow(num1, num2);
                break;
            case "perc":
                res = (num1*num2)/100;
                break;
            default:
                break;
        }

        resp.getWriter().println("""
                <h1>Result: %,.2f</h1>
                """.formatted(res));
    }
}

package com.lesson;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/questionnaire")
public class QuestionnaireServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String sub = req.getParameter("sub");
        String gender = req.getParameter("gender");


        if(phone != null && (Integer.parseInt(age) > 0 && Integer.parseInt(age) < 105) && email != null)
        {
            resp.getWriter().println("""
                <h1>Questionnaire</h1>
                <p>Name: %s</p>
                <p>Phone: %s</p>
                <p>Email: %s</p>
                <p>Age: %s</p>
                <p>Is subbed: %s</p>
                <p>Gender: %s</p>
                """.formatted(name, phone, email, age, sub, gender));
        }
        else
        {
            resp.getWriter().println("""
                    <h1>Error</h1>
                    <p>Invalid data. Try again</p>
                    """);
        }

    }
}

package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/editquote")
public class EditQuotesServlet extends HttpServlet
{
    private List<String> quotes = new ArrayList<>();

    public void init()
    {
        quotes.add("Those who do not remember the past are condemned to repeat it.");
        quotes.add("Teaching is more than imparting knowledge; it is inspiring change.");
        quotes.add("Be The Change You Want To See In The World.");
        quotes.add("Choose love, especially when love is the hardest.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int quoteid;
        String response = "";
        String newquote = "";
        String newauthor = "";
        String newcategory = "";
        if(req.getParameter("quoteid") != null && req.getParameter("editq") != null && req.getParameter("edita") != null && req.getParameter("editc") != null)
        {
            quoteid = Integer.parseInt(req.getParameter("quoteid"));
            newquote = req.getParameter("editq");
            newauthor = req.getParameter("edita");
            newcategory = req.getParameter("editc");

            quotes.set(quoteid, newquote + "\tAuthor: " + newauthor + "\tCategory: " + newcategory);

            for (String i : quotes)
            {
                response = response + i + "<br>";
            }
        }

        req.setAttribute("quote", response);
        req.getRequestDispatcher("/editquotes.jsp").forward(req, resp);

    }

}

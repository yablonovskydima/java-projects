package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findquote")
public class FindQuoteServlet extends HttpServlet
{
    private List<String> quotes = new ArrayList<>();
    private String quote;

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

        String word = req.getParameter("findq");
        String quote = " ";
        if(word != null)
        {
            for (String i :quotes)
            {
                if(i.toLowerCase().contains(word.toLowerCase()))
                {
                    quote = quote + i + "<br>";
                }
            }
        }


        req.setAttribute("quote", quote);
        req.getRequestDispatcher("/findquote.jsp").forward(req, resp);
    }


}

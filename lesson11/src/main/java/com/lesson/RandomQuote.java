package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/randquote")
public class RandomQuote extends HttpServlet
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
        String quote = "";
        String category = req.getParameter("category");
        if(category != null)
        {
            switch (category)
            {
                case "education":
                    quote = quotes.get(1);
                    break;
                case "development":
                    quote = quotes.get(2);
                    break;
                case "relationship":
                    quote = quotes.get(3);
                    break;
                case "history":
                    quote = quotes.get(0);
                    break;
                default:
                    break;
            }
        }
        else
        {
            Random random = new Random();
            int i = random.nextInt(quotes.size());
            quote = quotes.get(i);
        }


        req.setAttribute("quote", quote);
        req.getRequestDispatcher("/rquote.jsp").forward(req, resp);
    }
}

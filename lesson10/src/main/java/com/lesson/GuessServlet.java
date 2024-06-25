package com.lesson;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/guess")
public class GuessServlet extends HttpServlet
{

    public int target = new Random().nextInt(100-1)+1;
    public int min = 1;
    public int max = 100;
    public int guesses = 0;
    public String message = " ";
    public  boolean isWon = false;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(isWon)
        {
            message = " ";
            isWon = false;
            req.getRequestDispatcher("/guessresults.jsp?tries="+guesses+"&num="+target).forward(req, resp);
            guesses=0;
            target = new Random().nextInt(100-1)+1;
        }
        else
        {
            req.setAttribute("message", message);
            req.getRequestDispatcher("/guessnumber.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if (req.getParameter("guess") != null)
        {
            int guess = Integer.parseInt(req.getParameter("guess"));
            if(guess == target)
            {
                isWon = true;
            }
            else
            {
                guesses++;
                if(guess > target)
                {
                    message = "Try lower!";
                }
                else
                {
                    message = "Try higher!";
                }
            }
        }
        resp.sendRedirect("guess");
    }

}

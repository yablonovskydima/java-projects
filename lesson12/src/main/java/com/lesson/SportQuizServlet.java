package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@WebServlet("/sportquiz")
public class SportQuizServlet extends HttpServlet
{
    public int question_id = 0;
    public long startTime = System.currentTimeMillis();
    public int length;
    public int rcount=0;
    public int wcount=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        length = SportQuiz.questions.size()-1;
        if(question_id < SportQuiz.questions.size())
        {
            String question = SportQuiz.questions.get(question_id);
            String answer = SportQuiz.answers.get(question_id);
            String wronganswer = SportQuiz.wronganswers.get(question_id);
            req.setAttribute("question", question);
            req.setAttribute("answer", answer);
            req.setAttribute("wronganswer", wronganswer);
            req.getRequestDispatcher("/sportquiz.jsp?question_id="+question_id+"&length="+length).forward(req, resp);

        }
        else
        {
            long time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime);

            req.getRequestDispatcher("/results.jsp?quiz=sport&rights="+rcount+"&wrongs="+wcount+"&time="+time).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(question_id == length)
        {
            if(req.getParameter("answer")!=null)
            {
                String answer = req.getParameter("answer");
                if(!answer.equals(SportQuiz.answers.get(question_id)))
                {
                    SportQuiz.wrongquestionid.add(question_id);
                    wcount++;
                }
                else
                {
                    rcount++;
                }
            }
        }
        else
        {
            String choice = req.getParameter("choose");
            if(choice.equals("false"))
            {
                SportQuiz.wrongquestionid.add(question_id);
                wcount++;
            }
            else
            {
                rcount++;
            }
        }
        question_id++;
        resp.sendRedirect("sportquiz");
    }
}

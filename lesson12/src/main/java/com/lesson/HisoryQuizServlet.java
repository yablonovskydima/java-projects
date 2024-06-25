package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@WebServlet("/historyquiz")
public class HisoryQuizServlet extends HttpServlet
{
    public int question_id = 0;
    public long startTime = System.currentTimeMillis();
    public int length;
    public int rcount=0;
    public int wcount=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        length = HistoryQuiz.questions.size()-1;
        if(question_id < HistoryQuiz.questions.size())
        {
            String question = HistoryQuiz.questions.get(question_id);
            String answer = HistoryQuiz.answers.get(question_id);
            String wronganswer = HistoryQuiz.wronganswers.get(question_id);
            HttpSession session = req.getSession();
            session.setAttribute("startTime", System.currentTimeMillis());
            req.setAttribute("question", question);
            req.setAttribute("answer", answer);
            req.setAttribute("wronganswer", wronganswer);
            req.getRequestDispatcher("/historyquiz.jsp?question_id="+question_id+"&length="+length).forward(req, resp);

        }
        else
        {
            long time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime);
            req.getRequestDispatcher("/results.jsp?quiz=history&rights="+rcount+"&wrongs="+wcount+"&time="+time).forward(req, resp);
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
               if(!answer.equals(HistoryQuiz.answers.get(question_id)))
               {
                   HistoryQuiz.wrongquestionid.add(question_id);
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
                HistoryQuiz.wrongquestionid.add(question_id);
                wcount++;
            }
            else
            {
                rcount++;
            }
        }
        question_id++;
        resp.sendRedirect("historyquiz");
    }
}

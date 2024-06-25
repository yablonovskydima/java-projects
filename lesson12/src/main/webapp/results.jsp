<%@ page import="java.util.List, java.util.ArrayList, com.lesson.HistoryQuiz, com.lesson.SportQuiz, com.lesson.SpaceQuiz" %>
<%
    String quiz = request.getParameter("quiz");
    String rights = request.getParameter("rights");
    String wrongs = request.getParameter("wrongs");
    String time = request.getParameter("time");
    List<String> qstns = new ArrayList<>();
    List<Integer> wrong = new ArrayList<>();
    if(quiz.equals("history"))
    {
        qstns = HistoryQuiz.questions;
        wrong = HistoryQuiz.wrongquestionid;
    }
    else if(quiz.equals("sport"))
    {
        qstns = SportQuiz.questions;
        wrong = SportQuiz.wrongquestionid;
    }
    else if (quiz.equals("space"))
    {
        qstns = SpaceQuiz.questions;
        wrong = SpaceQuiz.wrongquestionid;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Results</title>
</head>
<body>
    <h1>Results:</h1>
    <%
        for(int i = 0; i < qstns.size(); i++)
        {
            for(int j = 0; j < wrong.size(); j++)
            {
                if(wrong.get(j) == i)
                {
                    out.println("<p style='background-color: red'>"+qstns.get(i)+"</p>");
                    break;
                }
                else
                {
                     out.println("<p style='background-color: green'>"+qstns.get(i)+"</p>");
                     break;
                }
            }
        }
    %>
    <h1>Correct answers: <%out.println(rights);%></h1>
    <h1>Wrong answers: <%out.println(wrongs);%></h1>
    <h1>Overall time for the quiz: <%out.println(time);%></h>
    <h1>Average time for one question: <%out.println(Double.parseDouble(time)/10);%></h>
</body>
</html>
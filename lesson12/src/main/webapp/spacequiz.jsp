<%
    String question_id = request.getParameter("question_id");
    String length = request.getParameter("length");

%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>History</title>
</head>
<body>
    <h3><%= request.getAttribute("question") %></h3>

    <%
        if(question_id.equals(length))
        {
            out.println("<form method='POST' action='spacequiz' name='spaceform' id='sform'>");
            out.println("<input type='text' name='answer'>");
            out.println("<input type='submit' value='Go' id='submitbtn'>");
            out.println("</form>");
        }
        else
        {
            out.println("<form method='POST' action='spacequiz' name='spaceform' id='sform'>");
            out.println(request.getAttribute("answer") + "<input type='radio' name='choose' value='true'><br>");
            out.println(request.getAttribute("wronganswer") + "<input type='radio' name='choose' value='false' checked><br>");
            out.println("<input type='submit' value='Go' id='submitbtn'>");
            out.println("</form>");
        }
    %>

    <br><br>
    <div><p id="text_t">Time left:</p><span id="timer">30</span></div>
    <script>
            var timer = document.getElementById("timer");
            var text_t = document.getElementById("text_t");
            var form = document.getElementById("sform");

            let time = 30;
            var timerInterval = setInterval(()=>{
                time--;
                timer.textContent  = time;

                if(time <= 0)
                {
                    clearInterval(timerInterval);
                    text_t.textContent  = "Time's up!";
                    form.submit();
                }
            }, 1000);

        </script>
</body>
</html>
<%
    String tries = request.getParameter("tries");
    String num = request.getParameter("num");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Game "Guess number"</title>
</head>
<body>
    <h1>Congrats!</h1>
    <h2>You guessed the number <%out.println(num);%> with <%out.println(tries);%> tries!</h2>
    <h3><a href="guess">Again</a></h3>
</body>
</html>
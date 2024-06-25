<!DOCTYPE html>
<html>
<head>
    <title>Game "Guess number"</title>
</head>
<body>
    <h1>Game "Guess the number from 1 to 100"</h1>
    <form method="POST" action="guess">
        Input number:<input type="text" name="guess"><br>
        <input type="submit" value="Go">
    </from>
    <h3><%=request.getAttribute("message")%></h3>
</body>
</html>
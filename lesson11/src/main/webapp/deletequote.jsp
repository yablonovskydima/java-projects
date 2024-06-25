<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete quotes</title>
</head>
<body>
    <h1>Delete quotes</h1>
    <form>
        Input quote id:<br>
        <input type="text" name="quoteid"><br>
        <input type="submit">
    </form>
    <h1>All Quotes: </h1>
    <h3><%= request.getAttribute("quote") %></h3>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add quotes</title>
</head>
<body>
    <h1>Add quotes</h1>
    <h1><a href="editquote">Edit quote</a></h1>
    <h1><a href="deletequotes">Delete quote</a></h1>
    <form>
        Input quote:<br>
        <input type="text" name="addq"><br>
        Input author:<br>
        <input type="text" name="adda"><br>
        Input category:<br>
        <input type="text" name="addc"><br>
        <input type="submit">
    </form>
    <h1>All Quotes: </h1>
    <h3><%= request.getAttribute("quote") %></h3>
</body>
</html>
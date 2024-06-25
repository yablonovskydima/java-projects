<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add quotes</title>
</head>
<body>
    <h1>Edit quotes</h1>
    <form>
        Input quote id:<br>
        <input type="text" name="quoteid"><br>
        Input quote:<br>
        <input type="text" name="editq"><br>
        Input author:<br>
        <input type="text" name="edita"><br>
        Input category:<br>
        <input type="text" name="editc"><br>
        <input type="submit">
    </form>
    <h1>All Quotes: </h1>
    <h3><%= request.getAttribute("quote") %></h3>
</body>
</html>
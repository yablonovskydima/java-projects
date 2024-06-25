<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Random quotes</title>
</head>
<body>
    <h1>Quote by category</h1>
    <form>
        Input category:<br>
        <input type="radio" name="category" value="education">Education<br>
        <input type="radio" name="category" value="development">Self Development<br>
        <input type="radio" name="category" value="relationship">Relationship<br>
        <input type="radio" name="category" value="history">History<br>
        <input type="submit">
    </form>
    <h1>Quote: </h1>
    <h3><%= request.getAttribute("quote") %></h3>
</body>
</html>
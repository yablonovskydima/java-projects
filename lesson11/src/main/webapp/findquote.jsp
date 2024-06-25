<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Random quotes</title>
</head>
<body>
    <h1>Find quotes by word</h1>
    <form>
        Input word:<br>
        <input type="text" name="findq" value=" "><br>
        <input type="submit">
    </form>
    <h1>Quote: </h1>
    <h3><%= request.getAttribute("quote") %></h3>
</body>
</html>
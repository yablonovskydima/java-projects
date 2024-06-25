<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Questionnaire</title>
</head>
<body>
    <h1>Input data in questionnaire:</h1>
    <form action="questionnaire" method="GET">
        <p>Full name: <input type="text" name="name"></p>
        <p>Phone: <input type="text" name="phone"></p>
        <p>Email: <input type="text" name="email"></p>
        <p>Age: <input type="text" name="age"></p>
        <p>Do you want to subscribe?: <input type="checkbox" name="sub"></p>
        <p>Select your gender: male<input type="radio" name="gender" value="male">female<input type="radio" name="gender" value="female">other<input type="radio" name="gender" value="other"></p>
        <input type="submit" value="Send">
    </form>
</body>
</html>
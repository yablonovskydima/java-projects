<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Make Order</title>
</head>
<body>
    <h1>Choose a Pizza</h1>
    <form method="POST" action="order">
        Margarita pizza<input type="radio" name="pizza" value="Margarita pizza"><br>
        Quatro Formagio pizza<input type="radio" name="pizza" value="Quatro Formagio"><br>
        Caprichoza pizza<input type="radio" name="pizza" value="Caprichoza pizza"><br>
        Hawaii pizza<input type="radio" name="pizza" value="Hawaii pizza"><br>
        Additional topings:<br>
        Olives<input type="checkbox" name="toping" value="Olives">Capers<input type="checkbox" name="toping" value="Capers">Additional Cheese<input type="checkbox" name="toping" value="Cheese"><br><br>
        <br><br>
        <h2><a href="cutomorder">Make custom pizza</a></h2>
        <br><br><br>
        <h1>Personal Info</h1>
        Input your name<input type="text" name="name"><br>
        Input your phone number<input type="text" name="phone"><br>
        Input your email<input type="text" name="email"><br>
        Input your street(without number)<input type="text" name="address"><br>
        <div>
            <img width="875px" height="500px" src="Media/map.png" alt="">
        </div>
        <input type="submit" value="Make Order">
    </form>
</body>
</html>
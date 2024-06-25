<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Build Your Pizza</title>
</head>
<body>
   <h1>Build Your Pizza</h1>
   <form method="POST" action="cutomorder">
       <h3>Sauce:</h3>
       Tomato sauce<input type="radio" name="sauce" value="Tomato sauce">Cream sauce<input type="radio" name="sauce" value="Cream sauce">
       <h3>Toping 1:</h3>
       Peperoni<input type="checkbox" name="toping1" value="Peperoni">Ham<input type="checkbox" name="toping1" value="Ham">Chicken<input type="checkbox" name="toping1" value="Chicken">
       <h3>Toping 2:</h3>
       Mushrooms<input type="checkbox" name="toping2" value="Mushrooms">Tomatoes<input type="checkbox" name="toping2" value="Tomatoes">Lettuce<input type="checkbox" name="toping2" value="Lettuce">
       <h3>Cheese:</h3>
       Mozzarella<input type="radio" name="cheese" value="Mozzarella">Parmesan<input type="radio" name="cheese" value="Parmesan">Pecorino<input type="radio" name="cheese" value="Pecorino">
       <br><br><br>
       <h1>Personal info</h1>
       Input your name<input type="text" name="name"><br>
       Input your phone number<input type="text" name="phone"><br>
       Input your email<input type="text" name="email"><br>
       Input your street(without number)<input type="text" name="address"><br>
       <input type="submit" value="Make Order">
   </form>
</body>
</html>
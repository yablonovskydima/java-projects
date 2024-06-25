<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Тimer</title>
</head>
<body>
    <h1>Timer</h1>

    <form id="countdownForm">
        Input time in seconds:
        <input type="text" name="countdownTime" required>
        <input type="submit" value="Start">
    </form>

    <p>Seconds left: <span id="countdownDisplay">0</span></p>

    <script>
        document.getElementById("countdownForm").addEventListener("submit", function(event) {
            event.preventDefault();
            var countdownTime = parseInt(this.countdownTime.value, 10);
            startCountdown(countdownTime);
        });

        function startCountdown(countdownTime) {
            var countdownDisplay = document.getElementById("countdownDisplay");
            var intervalId;

            var updateCountdown = function() {
                if (countdownTime >= 0) {
                    countdownDisplay.textContent = countdownTime;
                    countdownTime--;
                } else {
                    clearInterval(intervalId);
                    countdownDisplay.textContent = "Time is up! ";
                }
            };

            intervalId = setInterval(updateCountdown, 1000);
            updateCountdown();
        }
    </script>
</body>
</html>
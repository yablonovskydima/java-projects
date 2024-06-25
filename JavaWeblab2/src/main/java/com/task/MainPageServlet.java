package com.task;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/main")
public class MainPageServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try (PrintWriter writer = resp.getWriter())
        {
            writer.println("""
                    <nav>
                        <a href="main">General info</a><br>
                        <a href="history">City history</a><br>
                        <a href="landmarks">Landmarks</a><br>
                        <a href="hotels_and_restaurants">Hotels & Restaurants</a><br>
                    </nav>
                    <br/>
                    <br/>
                    """);

            String labelTemplate = "<strong>%s</strong>: <i>%s</i><br/>";
            writer.printf(labelTemplate, "City name", "Ivano-Frankivsk");
            writer.printf(labelTemplate, "Country name", "Ukraine");
            writer.printf(labelTemplate, "Number of citizens ", "200000");
            writer.println("<strong>Brief history</strong>: <p style='width: 500px'>Місто Івано-Франківськ (колишній Станиславів) – сьогодні є одним із 24 обласних центрів України, адміністративний, економічний і культурний центр Івано-Франківської області, загальною площею 83,73 кв. км з чисельністю населення понад 240 тисяч мешканців.\n" +
                    "      Розташоване у міжріччі двох Бистриць (Надвірнянської та Солотвинської) на місці стародавнього українського села Заболоття і було засноване у 1661 році як фортеця, а у 1662 році одержало Магдебурзьке право.\n" +
                    "      Місто було засноване Андрієм Потоцьким, представником давнього галицького магнатського роду, який володів значними латифундіями на Покутті.</p>");
            writer.println("<img src='https://dovkola.media/wp-content/uploads/2021/08/DSCF4157-1024x682.jpg'/><br>");
        }
    }
}

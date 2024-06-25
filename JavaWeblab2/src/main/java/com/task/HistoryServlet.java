package com.task;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("""
                <h3>Iвано-Франківськ – молоде європейське місто, одне з відомих економічних, 
                    культурних та архітектурних центрів Західної України. Розташоване місто 
                    на Покутській рівнинній території південного заходу України на відстані 
                    150-300 км від кордонів Польщі, Румунії, Угорщини, Словаччини. Вигідне 
                    географічне розташування міста Івано-Франківська відносно сусідніх обласних
                     центрів та деяких міст України та Європи, а також кордону з сусідніми державами,
                      демонструє картосхема. Місто справедливо вважається східними і північними воротами Карпат.
                    Місто Івано-Франківськ (колишній Станиславів) – сьогодні є одним із 24 обласних 
                    центрів України, адміністративний, економічний і культурний центр Івано-Франківської 
                    області, загальною площею 83,73 кв. км з чисельністю населення понад 240 тисяч мешканців.</h3><br><br>
                    <p><a href="https://www.mvk.if.ua/history/114">Посилання на історію міста</a></p>
                """);

        writer.println("<img width='960px' height='766px' src='https://novynarnia.com/wp-content/uploads/2021/04/ivano-frankivsk.jpg' />");
    }
}

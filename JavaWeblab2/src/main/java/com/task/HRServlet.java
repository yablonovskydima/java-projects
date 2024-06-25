package com.task;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hotels_and_restaurants")
public class HRServlet  extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String pattern = "<h4>%d) %s</h4><br><img src='%s'>";
        try (PrintWriter writer = resp.getWriter())
        {
            writer.println("<h1>Готелі та ресторани: </h1>");
            writer.printf(pattern, 1, "<a href='nadiya.jsp'>Готель 'Надія'</a>", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/24/ff/e9/70/main-photonew.jpg?w=700&h=-1&s=1");
            writer.println("<p style='width:900px; border: 1px solid black;'>Найбільш відомий готель і найбільш впізнавана будівля міста</p>");
            writer.printf(pattern, 2, "<a href='dnister.jsp'>Готель 'Дністер'</a>", "https://www.nadiyahotel.com/images/ivano-fr/hoteldnister.jpg");
            writer.println("<p style='width:900px; border: 1px solid black;'>Готель та історична пам'ятка національного значення у центрі Івано-Франківська.</p>");
            writer.printf(pattern, 3, "<a href='shampaneria.jsp'>Ресторан 'Шампанерія'</a>", "https://10619-2.s.cdn12.com/rests/original/407_503721427.jpg");
            writer.println("<p style='width:900px; border: 1px solid black;'>Розкішний ресторна в серці міста.</p>");
        }
    }
}

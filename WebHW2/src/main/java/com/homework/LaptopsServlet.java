package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/laptops")
public class LaptopsServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String pattern = """
                <img width='300px' height='300px' src='%s'>
                <h3><a href='%s'>%s</a></h3>
                <p>%d UAH</p>
                """;
        resp.getWriter().println("<h1>Laptops</h1><be>");
        resp.getWriter().printf(pattern, "https://content.rozetka.com.ua/goods/images/big/248027774.jpg", "laptop1.jsp","ProArt Studiobook 16 OLED", 180000);
        resp.getWriter().printf(pattern, "https://brain.com.ua/static/images/prod_img/1/6/U0854216_3big_1694902755.jpg", "laptop2.jsp","Zenbook 13 OLED", 430000);
        resp.getWriter().printf(pattern, "https://img.telemart.ua/458990-597579-product_popup/asus-vivobook-14x-oled-x1403za-km100w-90nb0wq2-m00c00-quiet-blue.jpg", "laptop3.jsp","PASUS Vivobook 14X OLED", 25000);
    }
}

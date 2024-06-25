package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        resp.getWriter().println("""
                <h1>History</h1>
                <h4 style='width: 400px'>Established in 1989, ASUS is a multinational company known for the world’s best motherboards and high-quality personal computers, monitors, graphics cards, routers and other technology solutions. Today, ASUS is designing and building next-generation smart technologies to provide incredible experiences that enhance the lives of people everywhere.</h4>
                <div>
                    <img width='600px' height='300px' src='https://i0.wp.com/www.gadgetreactor.com/wp-content/uploads/2015/01/asus-history.jpg'><br>
                    <img width='300px' height='168px' src='https://history-computer.com/wp-content/uploads/2022/10/shutterstock_1916970155.jpg'>
                    <img width='300px' height='168px' src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzyZuW8oPfyvEoxlQeLm4flk0Bjc2XW5Kicg&usqp=CAU'>
                </div>
                <p><a href='https://www.asus.com/about-asus-history/'>Source</a></p>
                """);
    }
}

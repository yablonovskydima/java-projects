package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/order")
public class OrderServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String pizzaChoice = req.getParameter("pizza");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String[] topings = req.getParameterValues("toping");
        String i = " ";

        for (String val: topings)
        {
            i= i + val + " ";
        }

        Order.additionalToppings.add(i);
        Order.pizza.add(pizzaChoice);
        Order.clientName.add(name);
        Order.phoneNumber.add(phone);
        Order.email.add(email);

        for (String j: Order.availableAddress)
        {
            if(address.equals(j))
            {
                Order.address.add(address);
                break;
            }
            else
            {
                req.getRequestDispatcher("/addresserror.jsp").forward(req, resp);
            }
        }
        req.getRequestDispatcher("/allorders.jsp").forward(req, resp);
    }
}

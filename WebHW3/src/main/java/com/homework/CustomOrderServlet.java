package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cutomorder")
public class CustomOrderServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/customorder.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        String[] topings1 = req.getParameterValues("toping1");
        String[] topings2 = req.getParameterValues("toping2");

        String pizza = "Sauce: " + req.getParameter("sauce") +", First topings: ";
        for (String i:topings1)
        {
            pizza = pizza + i+", ";
        }
        pizza = pizza + "Second topings: ";
        for (String i :topings2)
        {
            pizza = pizza + i+", ";
        }

        pizza = pizza + "Cheese: " + req.getParameter("cheese");
        Order.pizza.add(pizza);
        Order.additionalToppings.add("None");
        Order.clientName.add(name);
        Order.phoneNumber.add(phone);
        Order.email.add(email);

        for (String j: Order.availableAddress)
        {
            if(address.toLowerCase().equals(j.toLowerCase()))
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

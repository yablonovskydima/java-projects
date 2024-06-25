package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/news")
public class NewsServlet  extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        String pattern = """                
                <h3><a href='%s'>%s</a></h3>
                <p style='width: 300px'>%s</p>
                <img width='300px' height='200px' src='%s'><br>
                """;

        resp.getWriter().println("<h1>News<h1><br>");
        resp.getWriter().printf(pattern,"new1.jsp", "\n" +
                "ASUS will offer a full line of Intel NUC devices","ASUS already manufactures and sells Intel NUC devices with 10th to 13th generation processors and will develop future NUC systems", "https://dlcdnwebimgs.asus.com/files/media/5ee3543d-03ec-4519-858a-fbc637b3ebbb/v1/features/images/large/2x/s1/main.webp");
        resp.getWriter().printf(pattern, "new2.jsp","The lightest 14\" business laptop with an OLED display is available in Ukraine", "\n" +
                "ASUS ExpertBook B9403 OLED is a reliable laptop with an OLED display that weighs less than 1 kg", "https://dlcdnwebimgs.asus.com/files/media/84f464cd-d248-420d-afcc-870f3cefbb9a/v2/features/images/large/2x/s3/main_small.jpg");
        resp.getWriter().printf(pattern, "new3.jsp","\n" +
                "ASUS presents the official online store in Ukraine", "\n" +
                "The store offers a wide range of modern ASUS and ROG laptops", "https://www.asus.com/media/odin/websites/US/News/k1ggmmoygs6i6ftw/zenbook17_fold.jpg");
    }
}

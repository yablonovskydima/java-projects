package com.task;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/landmarks")
public class LandmarksServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String pattern = "<h4>%d) %s</h4><br><img src='%s'>";
        try (PrintWriter writer = resp.getWriter())
        {
            writer.println("<h1>Визначні пам'ятки: </h1>");
            writer.printf(pattern, 1, "Міська ратуша", "https://gk-press.if.ua/wp-content/uploads/2016/03/120-900x595.jpg");
            writer.println("<p style='width:900px; border: 1px solid black;'>Першу ратушу в місті збудували в 1672 р. в стилі пізнього Ренесансу. Вона мала вигляд дев’ятиповерхової круглої вежі з кам’яною основою. Кілька разів споруда перебудовувалася. Зазнавши значних руйнувань під час Першої світової війни, ратуша після відбудови в 1935 р. набула хрестоподібного вигляду і так збереглася донині.</p>");
            writer.println("<a href='https://iftourism.com/places/ivano-frankivsk-city-hall'>Посилання на ресурс</a>");
            writer.printf(pattern, 2, "Парк імені Т.Г. Шевченка", "https://iftravel.com.ua/assets/gallery/84/12ece5837ef6b7cf85cacabccf0f49dc-1024x575_small.jpg");
            writer.println("<p style='width:900px; border: 1px solid black;'>Міський парк культури та відпочинку є пам’яткою садово-паркового мистецтва місцевого значення (з 1972 р). Як заповідний об’єкт він входить до складу природно-заповідного фонду і є складовою частиною світової системи природних територій та об’єктів.\n" +
                    "Його можна назвати й музеєм природи, адже, окрім місцевих порід, тут ростуть й екзотичні дерева і чагарники, завезені свого часу з розсадників Польщі, Франції та Америки. Зокрема, тут можна побачити рідкісне тюльпанове дерево та гінкго – єдиного представника родини гінкгових і найстарішого предка голонасінних, що зберігся до наших днів.</p>");
            writer.println("<a href='https://recreation.if.ua/park/'>Посилання на ресурс</a>");
            writer.printf(pattern, 3, "Залізничний вокзал", "https://pobudovano.com.ua/files/news/7143/photo/129351724_993258457862200_6361080498457789603_n.jpg");
            writer.println("<p style='width:900px; border: 1px solid black;'>Колію через Станиславів протягли в 1866 р. під час прокладення залізничної лінії Львів-Ходорів-Станіславів-Чернівці. Ця залізниця стала другою в Галичині після лінії Перемишль-Львів. Важко уявити, якою рідкістю в ті часи були залізничні перевезення. В 1896 р. вся залізниця величезної Австро-Угорської імперії  налічувала заледве 8 тис. кілометрів колії. Для порівняння: лише колії сучасної Львівської залізниці складають близько 4,5 тис. км.</p>");
            writer.println("<a href='https://firtka.if.ua/blog/view/cikavi-fakti-z-istorii-ivanofrankivskogo-vokzalu71310'>Посилання на ресурс</a>");
        }
    }
}

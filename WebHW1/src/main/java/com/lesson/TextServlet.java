package com.lesson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/text")
public class TextServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        resp.getWriter().println("""
                <h1>Text statistic</h1>
                <form>
                    <label>Input text</label><br>
                    <input type='text' name='textop'><br>
                    <input type='submit' value='Go'>
                </from>
                """);

        String text = req.getParameter("textop");
        int vowelCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;
        StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();
        StringBuilder punctuations = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if (isVowel(c)) {
                    vowelCount++;
                    vowels.append(c).append(" ");
                } else {
                    consonantCount++;
                    consonants.append(c).append(" ");
                }
            } else if (Character.isWhitespace(c)) {

            } else {
                punctuationCount++;
                punctuations.append(c).append(" ");
            }

        }

        resp.getWriter().println("""
                <h1>Statistics: </h1>
                <ul>
                    <li><p>Vowel count: %d</p></li>
                    <li><p>Vowel list: %s</p></li><br>
                    <li><p>Consonant count: %d</p></li>
                    <li><p>Consonant list: %s</p></li><br>
                    <li><p>Punctuation count: %d</p></li>
                    <li><p>Punctuation list: %s</p></li><br>
                </ul>
                """.formatted(vowelCount, vowels, consonantCount, consonants, punctuationCount, punctuations));
    }

    public static boolean isVowel(char c) {
        char lowercaseChar = Character.toLowerCase(c);
        return lowercaseChar == 'a' || lowercaseChar == 'e' || lowercaseChar == 'i' || lowercaseChar == 'o' || lowercaseChar == 'u';
    }


}


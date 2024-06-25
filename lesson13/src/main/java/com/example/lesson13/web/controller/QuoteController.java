package com.example.lesson13.web.controller;


import com.example.lesson13.domain.entity.Quote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/quote")
public class QuoteController
{
    @GetMapping("/rand")
    public ResponseEntity<String> randquote()
    {
        return ResponseEntity.ok(Quote.quotes.get(new Random().nextInt(Quote.quotes.size())).toString());
    }

    @GetMapping("/category")
    public ResponseEntity<String> quote(@RequestParam String category)
    {
        String quote = "No quote";
        for (Quote i: Quote.quotes)
        {
            if(i.getCateory().equals(category))
            {
                quote = i.toString();
            }
        }

        return  ResponseEntity.ok(quote);
    }
}

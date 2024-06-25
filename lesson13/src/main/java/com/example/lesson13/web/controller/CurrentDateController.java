package com.example.lesson13.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/current-day")
public class CurrentDateController
{
    @GetMapping
    public ResponseEntity<String> now(@RequestParam String locale)
    {
        DateFormat formatter = new SimpleDateFormat("EEEE", Locale.of(locale));
        return ResponseEntity.ok(formatter.format(new Date()));
    }
}

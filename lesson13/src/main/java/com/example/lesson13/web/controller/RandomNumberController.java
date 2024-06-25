package com.example.lesson13.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/random-num")
public class RandomNumberController
{
    @GetMapping
    public ResponseEntity<Integer> randomNum(@RequestParam int upperbound, @RequestParam int lowerbound)
    {
        return ResponseEntity.ok(new Random().nextInt(upperbound-lowerbound)+lowerbound);
    }
}

package com.homework.SpringHW1.web.controller;

import com.homework.SpringHW1.domain.entity.Fraction;
import com.homework.SpringHW1.domain.entity.FractionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fractions")
public class FractionController
{
    @GetMapping("/check")
    public ResponseEntity<String> check(@RequestBody Fraction fraction)
    {
        if (fraction.getDenominator() != 0)
        {
            if (fraction.getNumerator() < fraction.getDenominator()) {
                return ResponseEntity.ok("Fraction is correct");
            } else {
                return ResponseEntity.ok("Fraction is not correct");
            }
        }
        return ResponseEntity.ok("Denominator cannot equal zero");
    }

    @GetMapping("/add")
    public ResponseEntity<String> addFractions(
            @RequestBody FractionRequest req
    )
    {

        if(req.getFraction1().getDenominator() == 0 || req.getFraction2().getDenominator() == 0)
        {
            return ResponseEntity.ok("Denominator cannot be zero");
        }
        int numerator = req.getFraction1().getNumerator() * req.getFraction2().getDenominator() + req.getFraction2().getNumerator() * req.getFraction1().getDenominator();
        int denominator = req.getFraction1().getDenominator() * req.getFraction2().getDenominator();

        return ResponseEntity.ok(new Fraction(numerator, denominator).toString());
    }

    @GetMapping("/subtract")
    public ResponseEntity<String> subFraction(
            @RequestBody FractionRequest req
    )
    {
        int numerator = req.getFraction1().getNumerator() * req.getFraction2().getDenominator() - req.getFraction2().getNumerator() * req.getFraction1().getDenominator();
        int denominator = req.getFraction1().getDenominator() * req.getFraction2().getDenominator();
        int commond = Fraction.findCommonDenominator(numerator, denominator);
        numerator/=commond;
        denominator/=commond;
        return  ResponseEntity.ok(new Fraction(numerator, denominator).toString());
    }

    @GetMapping("/multiplication")
    public ResponseEntity<String> multiplyFraction(
            @RequestBody FractionRequest req
    )
    {
        int numerator = req.getFraction1().getNumerator() *  req.getFraction2().getNumerator();
        int denominator = req.getFraction1().getDenominator() * req.getFraction2().getDenominator();
        int commond = Fraction.findCommonDenominator(numerator, denominator);
        numerator/=commond;
        denominator/=commond;
        return  ResponseEntity.ok(new Fraction(numerator, denominator).toString());
    }

    @GetMapping("/division")
    public ResponseEntity<String> divideFraction(
            @RequestBody FractionRequest req
    )
    {
        int numerator = req.getFraction1().getNumerator() *  req.getFraction2().getDenominator();
        int denominator = req.getFraction1().getDenominator() * req.getFraction2().getNumerator();
        int commond = Fraction.findCommonDenominator(numerator, denominator);
        numerator/=commond;
        denominator/=commond;
        return  ResponseEntity.ok(new Fraction(numerator, denominator).toString());
    }

    @GetMapping("/reduce-fraction")
    public ResponseEntity<String> reduce(@RequestBody Fraction fraction)
    {
        int num = fraction.getNumerator();
        int denum = fraction.getDenominator();

        int commond = Fraction.findCommonDenominator(num, denum);
        num /= commond;
        denum /= commond;

        return ResponseEntity.ok(new Fraction(num, denum).toString());
    }
}

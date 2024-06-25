package com.lesson;

import java.util.ArrayList;
import java.util.List;

public class SportQuiz
{
    public static List<String> questions = new ArrayList<>();
    public static List<String> answers = new ArrayList<>();

    public static List<String> wronganswers = new ArrayList<>();
    public static List<Integer> wrongquestionid = new ArrayList<>();

    static {
        questions.add("Who is often referred to as 'The Greatest' in the world of boxing?");
        answers.add("Muhammad Ali");
        wronganswers.add("Mike Tyson");

        questions.add("Which country won the FIFA World Cup in 2018?");
        answers.add("France");
        wronganswers.add("Spain");

        questions.add("In which sport can you perform a slam dunk?");
        answers.add("Basketball");
        wronganswers.add("Tennis");

        questions.add("Which athlete is known as the 'Flying Finn'?");
        answers.add("Paavo Nurmi");
        wronganswers.add("Lionel Messi");

        questions.add("Which tennis player has the most Grand Slam titles in history?");
        answers.add("Roger Federer");
        wronganswers.add("Michael Jordan");

        questions.add("What is the highest achievable score in a single game of bowling?");
        answers.add("300");
        wronganswers.add("320");

        questions.add("Which country won the most gold medals in the 2020 Summer Olympics?");
        answers.add("United States");
        wronganswers.add("UK");

        questions.add("In which sport can you score a 'hat-trick'?");
        answers.add("Football (Soccer)");
        wronganswers.add("Basketball");

        questions.add("Who holds the record for the most home runs in a single MLB season?");
        answers.add("Barry Bonds");
        wronganswers.add("Tyson Fury");

        questions.add("Which city hosted the 2016 Summer Olympics?");
        answers.add("Rio de Janeiro");
        wronganswers.add("Berlin");

    }

}

package com.lesson;

import java.util.ArrayList;
import java.util.List;

public class SpaceQuiz
{
    public static List<String> questions = new ArrayList<>();
    public static List<String> answers = new ArrayList<>();

    public static List<String> wronganswers = new ArrayList<>();
    public static List<Integer> wrongquestionid = new ArrayList<>();

    static {
        questions.add("What is the largest planet in our solar system?");
        answers.add("Jupiter");
        wronganswers.add("Uranus");

        questions.add("Which space agency launched the Hubble Space Telescope?");
        answers.add("NASA");
        wronganswers.add("ESA");

        questions.add("What is the closest star to Earth?");
        answers.add("The Sun");
        wronganswers.add("Mars");

        questions.add("What is the name of the galaxy that includes the Milky Way?");
        answers.add("The Local Group");
        wronganswers.add("Andromeda");

        questions.add("What is the largest moon of Saturn?");
        answers.add("Titan");
        wronganswers.add("Reya");

        questions.add("Who was the first human to travel into space?");
        answers.add("Yuri Gagarin");
        wronganswers.add("Neil Armstrong");

        questions.add("Which planet is known as the 'Red Planet'?");
        answers.add("Mars");
        wronganswers.add("Venus");

        questions.add("What is the name of the largest volcano in the solar system, located on Mars?");
        answers.add("Olympus Mons");
        wronganswers.add("Everest");

        questions.add("What is the theory that suggests the universe began with a massive explosion?");
        answers.add("Big Bang Theory");
        wronganswers.add("String Theory");

        questions.add("What is the name of the first American woman in space?");
        answers.add("Sally Ride");
        wronganswers.add("Valentina Tereshkova");
    }
}

package com.lesson;

import java.util.ArrayList;
import java.util.List;

public class HistoryQuiz
{
    public static List<String> questions = new ArrayList<>();
    public static List<String> answers = new ArrayList<>();
    public static List<String> wronganswers = new ArrayList<>();
    public static List<Integer> wrongquestionid = new ArrayList<>();

    static {
        questions.add("During which war did the Battle of Waterloo take place?");
        answers.add("Napoleonic Wars");
        wronganswers.add("WW2");

        questions.add("Who was the first President of the United States?");
        answers.add("George Washington");
        wronganswers.add("Donald Trump");

        questions.add("In what year did the French Revolution occur?");
        answers.add("1789");
        wronganswers.add("1754");

        questions.add("Which country was divided by the 'Iron Curtain' after World War II?");
        answers.add("Germany");
        wronganswers.add("Yugoslavia");

        questions.add("Who was the founder of the Roman Empire?");
        answers.add("Octavian Augustus");
        wronganswers.add("Gelius Ceasar");

        questions.add("Who authored 'The Little Prince'?");
        answers.add("Antoine de Saint-Exupéry");
        wronganswers.add("William Shakespear");


        questions.add("Which famous literary figure created 'The Tomb of the Pharaoh'?");
        answers.add("Agatha Christie");
        wronganswers.add("J.K. Rowling");

        questions.add("Who was the first astronaut to travel to space?");
        answers.add("Yuri Gagarin");
        wronganswers.add("Neal Armstrong");

        questions.add("In what year was the Americans with Disabilities Act (ADA) passed in the USA?");
        answers.add("1990");
        wronganswers.add("1987");

    }

}

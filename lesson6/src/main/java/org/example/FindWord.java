package org.example;

import lombok.Getter;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class FindWord implements Callable
{
    private String[] words;
    @Getter
    private String word;


    public FindWord(String[] words, String word) {
        this.words = words;
        this.word = word;
    }

    public Integer call()
    {
        int count = 0;
        for(var w : words)
        {
            if(w.equals(word))
            {
                count++;
            }
        }

        return count;
    }
}

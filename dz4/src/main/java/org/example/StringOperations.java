package org.example;

public class StringOperations
{
    private String str;

    public StringOperations(String str)
    {
        this.str = str;
    }

    public boolean isPalindrom()
    {
        String rev = "";

        boolean res = false;

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        if (str.equals(rev)) {
            res = true;
        }
        return res;
    }

    public int vowelCount()
    {
        String[] c = str.split("(?!^)");
        int vowel=0;

        for (String s : c)
        {
            if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u"))
                vowel++;
        }

        return vowel;
    }

    public int consonantCount()
    {
        String[] c = str.split("(?!^)");
        int consonant=0;

        for (String s : c)
        {
            if (!s.equals("a") && !s.equals("e") && !s.equals("i") && !s.equals("o") && !s.equals("u"))
                consonant++;
        }
        return consonant;
    }

    public int wordCount(String word)
    {
        String[] c = str.split(" ");
        int count = 0;

        for(String w : c)
        {
            if(w.equals(word))
            {
                count++;
            }
        }
        return count;
    }
}

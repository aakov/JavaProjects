package com.example.kolokwium2home;

public class LineWord {
   public String time;
   public String word;
   public String timeWord;
    public String getWord() {
        return word;
    }


    public LineWord(String time, String word) {
        this.time = time;
        this.word = word;
        this.timeWord = time + " " + word;
    }

    @Override
    public String toString()
    {
        return  timeWord;
    }

    public boolean startsWith(String text)
    {
        if (word.startsWith(text))
        {
            return true;
        }
        else {
            return  false;
        }
    }
}

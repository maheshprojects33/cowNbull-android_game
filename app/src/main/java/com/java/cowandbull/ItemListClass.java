package com.java.cowandbull;


public class ItemListClass {
    String guessWord, cow, bull, sno;



    public ItemListClass(String guessWord, String cow, String bull, String sno) {
        this.guessWord = guessWord;
        this.cow = cow;
        this.bull = bull;
        this.sno = sno;
    }


    public String getGuessWord() {
        return guessWord;
    }

    public String getCow() {
        return cow;
    }

    public String getBull() {
        return bull;
    }

    public String getSno() {
        return sno;
    }
}

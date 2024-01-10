package study.controllers;


public class Game {
    int attempts = 6;
    String secretWord = "";


    public String sortWord() {
        Words words = new Words();
        secretWord = words.getWord();
        return secretWord;
    }
}

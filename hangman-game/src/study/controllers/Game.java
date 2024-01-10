package study.controllers;

public class Game {
    private int attempts = 10;
    private String secretWord = "";
    private boolean[] guessedLetters;

    public Game() {
        secretWord = getRandomWord();
        guessedLetters = new boolean[secretWord.length()];
    }

    public String displayWord() {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (guessedLetters[i]) {
                word.append(secretWord.charAt(i));
            } else {
                word.append("_");
            }
        }
        return word.toString();
    }

    public boolean checkLetter(String letter) {
        boolean correctGuess = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter.charAt(0)) {
                guessedLetters[i] = true;
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            attempts--;
        }

        return correctGuess;
    }

    public boolean isWordGuessed() {
        for (boolean guessedLetter : guessedLetters) {
            if (!guessedLetter) {
                return false;
            }
        }
        return true;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getSecretWord() {
        return secretWord;
    }

    private String getRandomWord() {
        Words words = new Words();
        return words.getWord();
    }
}

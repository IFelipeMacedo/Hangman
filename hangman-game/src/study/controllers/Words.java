package study.controllers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Words {
    private static final String PATH = "hangman-game/src/resources/words.txt";
    private List<String> dataBase;

    public Words() {
        dataBase = load();
    }

    public void addWord(String newWord) {
        dataBase.add(newWord.toUpperCase());
        save(dataBase);
    }

    public String getWord() {
        Random random = new Random();
        int randomNumber = random.nextInt(dataBase.size());
        return dataBase.get(randomNumber);
    }

    public List<String> getWords() {
        return dataBase;
    }

    private static List<String> load() {
        List<String> dataBase = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataBase.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataBase;
    }

    private static void save(List<String> dataBase) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))) {
            for (String word : dataBase) {
                bw.write(word);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

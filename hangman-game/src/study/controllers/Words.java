package study.controllers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Words {
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
        int randomNumber = random.nextInt(dataBase.size() + 1);
        return dataBase.get(randomNumber);
    }

    public static List<String> load() {
        List<String> dataBase = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("hangman-game/src/resources/words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataBase.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataBase;
    }

    public static void save(List<String> dataBase) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("hangman-game/src/resources/words.txt"))) {
            for (String word : dataBase) {
                bw.write(word);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> getWords() {
        return dataBase;
    }




}

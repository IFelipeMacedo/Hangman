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
    String way = "hangman-game/src/resources/words.txt";
    List<String> dataBase = load(way);

    public Words() {
        

    }

    public void addWord(String word) {
        dataBase.add(word);
    }

    public String getWord() {
        Random random = new Random();
        int randomNumber = random.nextInt(dataBase.size() + 1);
        return dataBase.get(randomNumber);
    }

    public static List<String> load(String way) {
        List<String> dataBase = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(way))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataBase.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataBase;
    }

    public static void save(String way, List<String> dataBase) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(way))) {
            for (String word : dataBase) {
                bw.write(word + "\n");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

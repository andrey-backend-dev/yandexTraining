package yandexTraining.hw4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordRepeatNum {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> word2repeats = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw4/input.txt"))) {
            for (String line : br.lines().toList()) {
                if (line.isEmpty())
                    continue;
                for (String word : line.trim().split(" ")) {
                    int repeats = word2repeats.getOrDefault(word, 0);
                    result.append(repeats).append(" ");
                    word2repeats.put(word, repeats + 1);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw4/output.txt"))) {
            bw.write(result.toString());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

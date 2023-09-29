package yandexTraining.hw4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheMostCommonWord {
    public static void main(String[] args) {
        Map<String, Integer> word2repeats = new HashMap<>();
        int maxValue = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw4/input.txt"))) {
            for (String line : br.lines().collect(Collectors.toList())) {
                if (line.isEmpty())
                    continue;
                for (String word : line.split(" ")) {
                    int repeats = word2repeats.getOrDefault(word, 0);
                    word2repeats.put(word, repeats + 1);
                    if (repeats + 1 > maxValue)
                        maxValue = repeats + 1;
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        List<String> lst = new ArrayList<>();

        for (Map.Entry<String, Integer> entrySet : word2repeats.entrySet()) {
            if (entrySet.getValue() == maxValue) {
                lst.add(entrySet.getKey());
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw4/output.txt"))) {
            bw.write(lst.stream().sorted().findFirst().get());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

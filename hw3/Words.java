package yandexTraining.hw3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Words {
    public static void main(String[] args) {
        Set<String> uniqueWords = new HashSet<>();
        uniqueWords.add("");
        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw3/input.txt"))) {
            for (String line : br.lines().collect(Collectors.toList())) {
                uniqueWords.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw3/output.txt"))) {
            bw.write(String.valueOf(uniqueWords.size() - 1));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
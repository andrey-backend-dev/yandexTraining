package yandexTraining.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Genome {
    public static void main(String[] args) {
        String firstGenome, secondGenome;
        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw3/input.txt"))) {
            firstGenome = br.readLine();
            secondGenome = br.readLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        String[] firstGenomeArr = new String[firstGenome.length() - 1];
        for (int i = 0; i < firstGenome.length() - 1; i++) {
            firstGenomeArr[i] = firstGenome.substring(i, i + 2);
        }

        Set<String> secondGenomeSet = new HashSet<>();
        for (int i = 0; i < secondGenome.length() - 1; i++) {
            secondGenomeSet.add(secondGenome.substring(i, i + 2));
        }

        int result = 0;
        for (String base : firstGenomeArr) {
            if (secondGenomeSet.contains(base))
                result++;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw3/output.txt"))) {
            bw.write(String.valueOf(result));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

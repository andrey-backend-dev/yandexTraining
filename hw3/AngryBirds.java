package yandexTraining.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AngryBirds {
    public static void main(String[] args) {
        Set<Integer> uniqueX = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw3/input.txt"))) {
            int n = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < n; i++) {
                uniqueX.add(Integer.parseInt(br.readLine().trim().split(" ")[0]));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw3/output.txt"))) {
            bw.write(String.valueOf(uniqueX.size()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

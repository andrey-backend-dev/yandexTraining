package yandexTraining.hw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Turtles {
    public static void main(String[] args) {
        Set<Integer> turtlesTruth = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw3/input.txt"))) {
            int n = Integer.parseInt(br.readLine().trim());
            Integer[] seq;

            for (int i = 0; i < n; i++) {
                seq = Arrays.stream(br.readLine().trim().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
                if (seq[0] >= 0 && seq[1] >= 0 && seq[0] + seq[1] == n - 1)
                    turtlesTruth.add(seq[0]);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw3/output.txt"))) {
            bw.write(String.valueOf(turtlesTruth.size()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

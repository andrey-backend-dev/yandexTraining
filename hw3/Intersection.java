package yandexTraining.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Intersection {
    public static void main(String[] args) {
        Set<Integer> set1, set2;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            set1 = new TreeSet<>(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
            set2 = new TreeSet<>(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        set1.retainAll(set2);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write(String.join(" ", set1.stream().map(String::valueOf).toArray(String[]::new)));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
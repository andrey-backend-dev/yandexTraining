package yandexTraining.hw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class OpenCalculator {
    public static void main(String[] args) {
        Set<String> digits;
        Set<String> buttons;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            buttons = Arrays.stream(br.readLine().trim().split(" ")).collect(Collectors.toSet());
            digits = Arrays.stream(br.readLine().split("")).collect(Collectors.toSet());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        digits.removeAll(buttons);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write(String.valueOf(digits.size()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
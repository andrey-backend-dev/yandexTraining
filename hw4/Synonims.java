package yandexTraining.hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Synonims {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        String word = "";
        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw4/input.txt"))) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] line;

            for (int i = 0; i < N; i++) {
                line = br.readLine().trim().split(" ");
                lst.add(line[0]);
                lst.add(line[1]);
            }

            word = br.readLine().trim();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        int wordIndex = lst.indexOf(word);
        String answer;

//        +1, because indexing starts from 0
        if ((wordIndex + 1) % 2 == 0)
            answer = lst.get(wordIndex - 1);
        else
            answer = lst.get(wordIndex + 1);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw4/output.txt"))) {
            bw.write(answer);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
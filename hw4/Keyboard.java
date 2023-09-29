package yandexTraining.hw4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class    Keyboard {
    public static void main(String[] args) {
        Map<Integer, Integer> keyboardIndex2Durability = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw4/input.txt"))) {
            int n = Integer.parseInt(br.readLine().trim());

            Integer[] durabilities = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            for (int i = 1; i < n + 1; i++) {
                keyboardIndex2Durability.put(i, durabilities[i - 1]);
            }

            int m = Integer.parseInt(br.readLine().trim());

            Integer[] taps = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            for (Integer tapIndex : taps) {
                keyboardIndex2Durability.put(tapIndex, keyboardIndex2Durability.get(tapIndex) - 1);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw4/output.txt"))) {
            for (Map.Entry<Integer, Integer> entrySet : keyboardIndex2Durability.entrySet()) {
                if (entrySet.getValue() >= 0)
                    bw.write("NO\n");
                else
                    bw.write("YES\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

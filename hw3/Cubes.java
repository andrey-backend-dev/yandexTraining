package yandexTraining.hw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Cubes {
    private static String printSet(Set<Integer> set) {
        StringBuilder result = new StringBuilder(set.size() + "\n");
        for (Integer integer : set) {
            result.append(integer).append(" ");
        }
        return result.toString().trim() + "\n";
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new TreeSet<>();
        int n, m;

        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw3/input.txt"))) {
            String[] firstRow = br.readLine().trim().split(" ");
            n = Integer.parseInt(firstRow[0]);
            m = Integer.parseInt(firstRow[1]);

            for (int i = 0; i < n; i++) {
                set1.add(Integer.parseInt(br.readLine()));
            }

            for (int i = 0; i < m; i++) {
                set2.add(Integer.parseInt(br.readLine()));
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        Set<Integer> set3 = new TreeSet<>(set1);
        set3.retainAll(set2);
        set1.removeAll(set3);
        set2.removeAll(set3);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw3/output.txt"))) {
            bw.write(printSet(set3));
            bw.write(printSet(set1));
            bw.write(printSet(set2));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
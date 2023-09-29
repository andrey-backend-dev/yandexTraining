package yandexTraining.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Languages {
    public static void main(String[] args) {
        Set<String> languages = new HashSet<>();
        Set<String> commonLanguages = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw3/input.txt"))) {
            int n = Integer.parseInt(br.readLine().trim());
            int m;
            String language;

            for (int i = 0; i < n; i++) {
                m = Integer.parseInt(br.readLine().trim());
                List<String> languagesPack = new ArrayList<>();

                for (int j = 0; j < m; j++) {
                    language = br.readLine().trim();
                    languagesPack.add(language);
                }

                if (i == 0)
                    commonLanguages.addAll(languagesPack);

                languages.addAll(languagesPack);
                commonLanguages.retainAll(languagesPack);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw3/output.txt"))) {
            bw.write(commonLanguages.size() + "\n");
            for (String language : commonLanguages)
                bw.write(language + "\n");

            bw.write(languages.size() + "\n");
            for (String language : languages)
                bw.write(language + "\n");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

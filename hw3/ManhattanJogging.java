package yandexTraining.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ManhattanJogging {
    public static void buildPossibleCoordsByRadius(int r, Integer[] coords, Set<String> possibleCoords) {
        possibleCoords.add(coords[0] + " " + coords[1]);
        if (r > 0) {
            buildPossibleCoordsByRadius(r - 1, new Integer[]{coords[0] + 1, coords[1]}, possibleCoords);
            buildPossibleCoordsByRadius(r - 1, new Integer[]{coords[0] - 1, coords[1]}, possibleCoords);
            buildPossibleCoordsByRadius(r - 1, new Integer[]{coords[0], coords[1] + 1}, possibleCoords);
            buildPossibleCoordsByRadius(r - 1, new Integer[]{coords[0], coords[1] - 1}, possibleCoords);
        }
    }

    public static void main(String[] args) {
        int t, d, n;
        Set<String> possibleCoords = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("./yandexTraining/hw3/input.txt"))) {
            Integer[] firstRow = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            t = firstRow[0];
            d = firstRow[1];
            n = firstRow[2];
            buildPossibleCoordsByRadius(t, new Integer[]{0, 0}, possibleCoords);

            for (int i = 0; i < n; i++) {
                Integer[] coords = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
                Set<String> possibleCoordsAroundCurrent = new HashSet<>();
                buildPossibleCoordsByRadius(d, coords, possibleCoordsAroundCurrent);
                possibleCoords.retainAll(possibleCoordsAroundCurrent);

                if (i == n - 1)
                    break;

                for (String coordsMatched : new HashSet<>(possibleCoords)) {
                    Integer[] coordsFormatted = Arrays.stream(coordsMatched.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
                    buildPossibleCoordsByRadius(t, coordsFormatted, possibleCoords);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./yandexTraining/hw3/output.txt"))) {
            bw.write(possibleCoords.size() + "\n");

            for (String coords : possibleCoords) {
                bw.write(coords + "\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

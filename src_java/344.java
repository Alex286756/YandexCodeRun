import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int w = Integer.parseInt(reader.readLine());
        List<Integer[]> white = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            String[] parts2 = reader.readLine().split(" ");
            int x = Integer.parseInt(parts2[0]);
            int y = Integer.parseInt(parts2[1]);
            white.add(new Integer[]{x, y});
        }
        int bl = Integer.parseInt(reader.readLine());
        List<Integer[]> black = new ArrayList<>();
        for (int i = 0; i < bl; i++) {
            String[] parts2 = reader.readLine().split(" ");
            int x = Integer.parseInt(parts2[0]);
            int y = Integer.parseInt(parts2[1]);
            black.add(new Integer[]{x, y});
        }
        String color = reader.readLine();

        if (color.equals("white"))
            writer.write(canEating(n, m, white, black));
        else
            writer.write(canEating(n, m, black, white));

        reader.close();
        writer.close();
    }

    public static String canEating(int n, int m,
                                List<Integer[]> myList, List<Integer[]> yourList) {
        for (Integer[] my : myList) {
            for (Integer[] your: yourList) {
                if ((Math.abs(my[0] - your[0]) == 1) && (Math.abs(my[1] - your[1]) == 1)) {
                    int new_x = my[0] + 2 * (your[0] - my[0]);
                    int new_y = my[1] + 2 * (your[1] - my[1]);
                    if ((new_x > 0) && (new_x <= n) &&
                            (new_y > 0) && (new_y <= m)) {
                        boolean q = true;
                        for (Integer[] i : myList)
                            if ((i[0] == new_x) && (i[1] == new_y)) {
                                q = false;
                                break;
                            }
                        for (Integer[] i : yourList)
                            if ((i[0] == new_x) && (i[1] == new_y)) {
                                q = false;
                                break;
                            }
                        if (q)
                            return "Yes";
                    }
                }

            }
        }
        return "No";
    }
}

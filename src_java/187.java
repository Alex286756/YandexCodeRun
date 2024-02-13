import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] parts = reader.readLine().split(" ");

            int[] lays = new int[n];
            for (int s = 0; s < n; s++) {
                lays[s] = Integer.parseInt(parts[s]);
            }
            Arrays.sort(lays);

            int difference = Integer.MAX_VALUE;
            for (int j = 0; j < n-1; j++) {
                int xor = lays[j] ^ lays[j+1];
                if (xor < difference)
                    difference = xor;
            }

            writer.write(Integer.toString(difference));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

}

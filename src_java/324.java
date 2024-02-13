import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int[] sellers = new int[n];
        int[] buyers = new int[m];

        String[] sel = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            sellers[i] = Integer.parseInt(sel[i]);
        }
        Arrays.sort(sellers);

        String[] buy = reader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            buyers[i] = Integer.parseInt(buy[i]);
        }
        Arrays.sort(buyers);

        int s = 0;
        int b = m - 1;
        long sum = 0;

        while (sellers[s] < buyers[b]) {
            sum += buyers[b] - sellers[s];
            s++;
            b--;
            if ((s == n) || (b == -1))
                break;
        }

        writer.write(Long.toString(sum));
        reader.close();
        writer.close();
    }

}

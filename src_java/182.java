import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        long nod = Long.parseLong(parts[0]);
        long nok = Long.parseLong(parts[1]);

        if (nok % nod > 0) {
            writer.write(Integer.toString(0));
            reader.close();
            writer.close();
            return;
        }

        long x = nok / nod;
        Set<Long> delitel = new HashSet<>();
        long start = 2L;

        while (x > 1 && start <= Math.sqrt(x)) {
            if (x % start == 0) {
                delitel.add(start);
                x = x / start;
            }
            else
                start++;
        }

        if (x > 1)
            delitel.add(x);

        writer.write(Long.toString((long) Math.pow(2, delitel.size())));

        reader.close();
        writer.close();
    }

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] parts = reader.readLine().split(" ");
        Map<Long, Integer> count = new HashMap<>();

        for (String str : parts) {
            long key = Long.parseLong(str);
            int value = count.get(key) == null ? 1 : count.get(key)+1;
            count.put(key, value);
        }

        int max = -1;
        long value = -1L;
        for (var entry :
                count.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                value = entry.getKey();
                continue;
            }
            if (entry.getValue() == max)
                if (entry.getKey() > value)
                    value = entry.getKey();
        }
        writer.write(Long.toString(value));

        reader.close();
        writer.close();
    }

}

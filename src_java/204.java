import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> servers = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            servers.add(Integer.valueOf(a * b));
        }

        int sum = servers.stream().reduce(0, Integer::sum);
        double[] res = servers.stream()
                .mapToDouble(e -> e.doubleValue()/sum).toArray();

        for (Double d : res) {
            writer.write(d.toString());
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

}

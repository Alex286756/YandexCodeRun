import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String j = reader.readLine();
        String s = reader.readLine();
        int sum = 0;

        for (char ch : s.toCharArray()) {
            if (j.indexOf(ch) != -1) {
                sum++;
            }
        }

        writer.write(Integer.toString(sum));

        reader.close();
        writer.close();
    }

}

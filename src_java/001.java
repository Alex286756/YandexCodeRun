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
        int[] array = new int[3];
        for (int i = 0; i < 3; i++)
            array[i] = Integer.parseInt(parts[i]);

        Arrays.sort(array);

        writer.write(Integer.toString(array[1]));

        reader.close();
        writer.close();
    }

}

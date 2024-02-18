import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int n_material = Integer.parseInt(parts[0]);
        int m_one_zagotovki = Integer.parseInt(parts[1]);
        int k_one_detal = Integer.parseInt(parts[2]);

        if ((n_material < m_one_zagotovki) || (m_one_zagotovki < k_one_detal)) {
            writer.write("0");
            reader.close();
            writer.close();
            return;
        }
        int count = 0;
        int count_zagotovok = n_material / m_one_zagotovki;
        int count_detalei_v_zagotovke = m_one_zagotovki / k_one_detal;
        int ostatok_one_zagotovki = m_one_zagotovki % k_one_detal;

        while (count_zagotovok > 0) {
            int n_ostatok = n_material % m_one_zagotovki;
            count += count_detalei_v_zagotovke * count_zagotovok;
            int ostatok_material = count_zagotovok * ostatok_one_zagotovki;
            n_material = n_ostatok + ostatok_material;
            count_zagotovok = n_material / m_one_zagotovki;
        }
        writer.write(String.valueOf(count));

        reader.close();
        writer.close();
    }
}

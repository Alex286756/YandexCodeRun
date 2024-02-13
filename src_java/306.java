import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = reader.readLine();
        while (str != null) {
            String[] parts = str.split(" ");
            int day = Integer.parseInt(parts[0]);
            int month;
            switch (parts[1]) {
                case "January" -> month = 0;
                case "February" -> month = 1;
                case "March" -> month = 2;
                case "April" -> month = 3;
                case "May" -> month = 4;
                case "June" -> month = 5;
                case "July" -> month = 6;
                case "August" -> month = 7;
                case "September" -> month = 8;
                case "October" -> month = 9;
                case "November" -> month = 10;
                default -> month = 11;
            }
            int year = Integer.parseInt(parts[2]);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);

            String week;
            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case 1 -> week = "Sunday";
                case 2 -> week = "Monday";
                case 3 -> week = "Tuesday";
                case 4 -> week = "Wednesday";
                case 5 -> week = "Thursday";
                case 6 -> week = "Friday";
                default -> week = "Saturday";
            }
            writer.write(week);
            writer.newLine();
            str = reader.readLine();
        }

        reader.close();
        writer.close();
    }

}

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Api2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        JSONObject feed = new JSONObject();
        JSONArray offers = new JSONArray();
        feed.put("offers", offers);
        JSONParser parser = new JSONParser();

        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            JSONObject parsed = (JSONObject) parser.parse(s);
            for (Object offer : parsed.values())
                for (Object oneOffer :(JSONArray) offer)
                    if (offers.size() < m)
                        offers.add(oneOffer);
        }

        writer.write(feed.toJSONString());
        reader.close();
        writer.close();
    }
}

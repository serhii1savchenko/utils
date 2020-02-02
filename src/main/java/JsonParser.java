import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class JsonParser {

    public static List<String> extractTracksFromShazamJson(File file) {
        List<String> result = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String jsonString = bufferedReader.readLine();
            bufferedReader.close();

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(jsonString);

            if (json.containsKey("tags")) {
                JSONArray tags = (JSONArray) json.get("tags");
                Iterator t = tags.iterator();

                while (t.hasNext()) {
                    JSONObject tag = (JSONObject) t.next();
                    JSONObject track = (JSONObject) tag.get("track");
                    JSONObject heading = (JSONObject) track.get("heading");
                    String trackNameAndArtist =
                            heading.get("title").toString() + " - " + heading.get("subtitle").toString();
                    result.add(trackNameAndArtist);
                }
            } else {
                System.out.println("Json has wrong format.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Total size = " + result.size());
        result = result.stream().distinct().collect(Collectors.toList());
        System.out.println("Without duplicates = " + result.size());

        return result;
    }

}

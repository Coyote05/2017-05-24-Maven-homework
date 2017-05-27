package homework11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    public static void printYoutubeJSON (String place) throws Exception{

        byte[] jsonData = Files.readAllBytes(Paths.get(place));

        ObjectMapper objectMapper = new ObjectMapper();

        Youtube youtube = objectMapper.readValue(jsonData, Youtube.class);

        System.out.println(objectMapper.writeValueAsString(youtube));
    }
}

package homework11;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    public static void printYoutubeJSON (String place) {

        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(place));

            ObjectMapper objectMapper = new ObjectMapper();

            Youtube youtube = objectMapper.readValue(jsonData, Youtube.class);

            System.out.println(objectMapper.writeValueAsString(youtube));

        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }

    public static void convertYoutubeJSONToXML (String fromPlace, String toPlace) {

        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(fromPlace));

            ObjectMapper objectMapper = new ObjectMapper();

            Youtube youtube = objectMapper.readValue(jsonData, Youtube.class);

            JAXBContext jaxbContext = JAXBContext.newInstance(Youtube.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File(toPlace);

            jaxbMarshaller.marshal(youtube, file);

            System.out.println("\n" + "converting: done");

        } catch (JAXBException e) {
            System.out.println("JAXBException " + e.getMessage());
        } catch (JsonParseException e) {
            System.out.println("JsonParseException " + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("JsonMappingException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
}

package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    private static final ObjectMapper mapper = new ObjectMapper();

    public String serialize() throws JsonProcessingException {
        return mapper.writeValueAsString(this);
    }

    public static Car unserialize(String json) throws IOException {
        try {
            return mapper.readValue(json, Car.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IOException("Failed to unserialize Car from JSON", e);
        }
    }
    // END
}

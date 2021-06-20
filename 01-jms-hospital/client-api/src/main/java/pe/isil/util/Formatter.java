package pe.isil.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Formatter {

    private final ObjectMapper objectMapper;

    public String objectToString(Object t){
        try {
            return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T stringToObject(String objectString, Class<T> t){
        try {
            return objectMapper.readValue(objectString, t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }



}

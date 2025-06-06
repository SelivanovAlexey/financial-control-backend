package app.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class JsonHelper {

    private final ObjectMapper mapper;

    public <K, V> String createJson(Map<K, V> inputMap) throws JsonProcessingException {
        return mapper.writeValueAsString(inputMap);
    }
}

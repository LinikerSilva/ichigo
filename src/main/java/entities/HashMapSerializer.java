package entities;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Map;

public class HashMapSerializer extends JsonSerializer<Map<Long, Object>> {

  ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

  @Override
  public void serialize(Map<Long, Object> hashMap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    mapper.writeValue(jsonGenerator, hashMap.values());
  }
}
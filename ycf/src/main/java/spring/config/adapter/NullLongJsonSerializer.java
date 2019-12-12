package spring.config.adapter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class NullLongJsonSerializer extends JsonSerializer<Object>{

  @Override
  public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException, JsonProcessingException {
    
    if (value == null) {
      gen.writeNumber(0);
    } else {
       gen.writeNumber((Long)value);
    }
    
  }

}

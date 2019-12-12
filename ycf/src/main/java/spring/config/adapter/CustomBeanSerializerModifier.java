package spring.config.adapter;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.math.BigDecimal;
import java.util.List;

public class CustomBeanSerializerModifier extends BeanSerializerModifier{
  
  private JsonSerializer<Object> _nullJsonSerializer = new NullStringJsonSerializer();

  @Override
  public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
          List<BeanPropertyWriter> beanProperties) {
    
      for (int i = 0; i < beanProperties.size(); i++) {
          BeanPropertyWriter writer = beanProperties.get(i);
          if (writer.getType().getRawClass().equals(String.class)) {
              writer.assignNullSerializer(this.defaultNullStringJsonSerializer());
          }else if(writer.getType().getRawClass().equals(Integer.class)){
             writer.assignNullSerializer(new NullIntegerJsonSerializer());
          }else if(writer.getType().getRawClass().equals(Long.class)){
             writer.assignNullSerializer(new NullLongJsonSerializer());
          }else if(writer.getType().getRawClass().equals(Short.class)){
            writer.assignNullSerializer(new NullShortJsonSerializer());
          }else if(writer.getType().getRawClass().equals(Byte.class)){
            writer.assignNullSerializer(new NullByteJsonSerializer());
          }else if(writer.getType().getRawClass().equals(BigDecimal.class)){
            writer.assignNullSerializer(new NullBigDecimalJsonSerializer());
          }
      }
      return beanProperties;
  }


  protected JsonSerializer<Object> defaultNullStringJsonSerializer() {
      return _nullJsonSerializer;
  }

}

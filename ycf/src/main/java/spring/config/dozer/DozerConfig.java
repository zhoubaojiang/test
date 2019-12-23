package spring.config.dozer;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:    对 象转换
 */
@Configuration
public class DozerConfig {
    @Bean
    public DozerBeanMapper dozerBean() {
        //List<String> mappingFiles = Arrays.asList("dozer-configration-mapping.xml");
        DozerBeanMapper dozerBean = new DozerBeanMapper();
        //dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }
}




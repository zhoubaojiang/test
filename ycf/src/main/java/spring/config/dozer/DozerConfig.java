package spring.config.dozer;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DG
 * @Description:    对 象转换
 * @date 2017/9/15 16:59
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




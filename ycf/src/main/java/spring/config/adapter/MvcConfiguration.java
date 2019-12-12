package spring.config.adapter;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import spring.version.handler.CustomRequestMappingHandlerMapping;

import javax.servlet.MultipartConfigElement;
import java.io.File;

/**
 * 版本控制配置
 * Created by 建宇 on 2017/10/28.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "spring", useDefaultFilters = false, includeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class }) })
public class MvcConfiguration extends WebMvcConfigurationSupport {

  /**
    * requestMapping重载，接口版本请求控制
    */
  @Override
  @Bean
  public RequestMappingHandlerMapping requestMappingHandlerMapping() {
      RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
      handlerMapping.setOrder(0);
      handlerMapping.setInterceptors(getInterceptors());
      return handlerMapping;
  }

    /**
     * 文件上传临时路径
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        File file = new File("/share/file");
        if (!file.exists()) { //如果不存在 则创建
            file.mkdirs();
        }
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("/share/file");
        return factory.createMultipartConfig();
    }
}

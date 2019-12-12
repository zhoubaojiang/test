package spring.config.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import spring.config.adapter.CustomBeanSerializerModifier;

import java.util.List;


@EnableWebMvc
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

	/**开启对跨域资源共享的支持 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//	        .allowedOrigins("*")
//	        .allowCredentials(true)
//	        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
//	        .maxAge(3600);
	}

	/** 文件上传请求解析 */
	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
		resolver.setResolveLazily(true);
		// 设置在文件上传时允许写到内存中的 最大值，以字节为单位计算，默认是10240
		resolver.setMaxInMemorySize(40960);
		//resolver.setMaxUploadSize(5L*1024*1024);//上传文件大小 5M 50*1024*1024字节
		return resolver;
	}

	/**
	 * 配置springmvc返回的对象自动将属性未null的转换未空字符串
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper mapper = converter.getObjectMapper();
		// 为mapper注册一个带有SerializerModifier的Factory，此modifier主要做的事情为：当序列化类型为array，list、set时，当值为空时，序列化成[]
		mapper.setSerializerFactory(mapper.getSerializerFactory().withSerializerModifier(new CustomBeanSerializerModifier()));
		converter.setSupportedMediaTypes(ImmutableList.of( MediaType.APPLICATION_JSON,MediaType.TEXT_HTML));
		converters.add(converter);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// swagger首页URL：http://localhost:9070/swagger-ui.html
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}


}

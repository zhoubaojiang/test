package spring.version.annotations;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * API版本注解
*
 * @author wenwj 
 * @date: 2017年11月16日 下午4:20:04 
* @since 1.0
 */
@Target({ElementType.METHOD,ElementType.TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
@Mapping
public @interface ApiVersion {
	
	/** 
     * 标识版本号 
     * @return 
     */  
    int value();  
}

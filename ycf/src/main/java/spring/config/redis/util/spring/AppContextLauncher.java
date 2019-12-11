package spring.config.redis.util.spring;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import java.util.Map;


public class AppContextLauncher implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException {
		AppContextLauncher.applicationContext = appContext;
	}
	
	/** 
     * @return ApplicationContext 
     */  
    public static ApplicationContext getApplicationContext() {
        return applicationContext;  
    }  
	/**
	 * 获取bean对象
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz){
		Assert.notNull(applicationContext, "Application Context not initialize");
		return applicationContext.getBean(clazz);
	}
	/**
	 * 获取 bean 对象
	 * @param beanName
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(String beanName,Class<T> clazz){
		Assert.notNull(applicationContext, "Application Context not initialize");
		return applicationContext.getBean(beanName, clazz);
	}

	/**
	 * @Description: 根据bean名称获取bean
	 * @param beanName      bean名称
	 * @return
	 * @author wangdg
	 * @date 2018/8/20 17:15
	 */
	public static Object getBean(String beanName){
		Assert.notNull(applicationContext, "Application Context not initialize");
		return applicationContext.getBean(beanName);
	}

	/**
	 * @Description: 根据bean的父类获取子类的bean
	 * @param superClass     bean的父类
	 * @return
	 * @author wangdg
	 * @date 2018/8/20 17:17
	 */
	public static  <T>Map<String,T> getBeans(Class<T> superClass){
		Assert.notNull(applicationContext, "Application Context not initialize");
		return applicationContext.getBeansOfType(superClass);
	}
}

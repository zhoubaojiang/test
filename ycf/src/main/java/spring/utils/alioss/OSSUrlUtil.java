package spring.utils.alioss;

import org.apache.commons.lang3.StringUtils;

/**
 * 
* 商品模块：Url统一处理工具类
* @author wenwj 
* @date: 2017年12月21日 下午2:35:28 
* @version 1.4.0
*
 */
public class OSSUrlUtil {

	/**
	 * 
	 * 功能描述: 全路径拼接<br>
	 * @author: wenwj
	 * @date: 2017年12月21日 下午2:46:05 
	 * @version 1.4.0
	 * @param url  前缀域名，后缀不包括"/"，如：http://***.***.com
	 * @param path  文件短路径，如:/img/path/2332.jpg
	 * @return 返回可访问全路径 url+path
	 */
	public static String contactUrlAndPath(String url,String path){
		String imgCompleteUrl = "";
		if(StringUtils.isNotBlank(url)&&StringUtils.isNotBlank(path)){
			if(!path.startsWith("/")){
				path = "/" + path;
			}
			imgCompleteUrl = url+path;
		}
		return imgCompleteUrl;
	}
	
	/**
	 * 
	 * 功能描述: 检查短路径是否已经加上"/"<br>
	 * @author: wenwj
	 * @date: 2017年12月21日 下午2:55:21 
	 * @version 1.4.0
	 * @param path
	 * @return 返回有效访问路径，前缀包括“/"
	 */
	public static String checkValidPath(String path){
		if(StringUtils.isNotBlank(path)){
			if(!path.startsWith("/")){
				path = "/" + path;
			}
		}
		return path;
	}
}

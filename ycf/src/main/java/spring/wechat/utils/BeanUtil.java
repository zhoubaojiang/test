package spring.wechat.utils;

import org.springframework.cglib.beans.BeanMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**     
 *  
 *
 * @author fenghui    
 * @date 2017年9月30日 上午11:37:45    
 */
public class BeanUtil {

	/**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, Object> xmlToMap(String strXML) throws Exception {
        try {
            Map<String, Object> data = new HashMap<String, Object>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
                // do nothing
            }
            return data;
        } catch (Exception ex) {
            throw ex;
        }

    }

    /**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
    public static String mapToXml(Map<String, String> data) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key: data.keySet()) {
            String value = data.get(key);
            if (value == null) {
                value = "";
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
        try {
            writer.close();
        }
        catch (Exception ex) {
        }
        return output;
    }
    
	    /** 
	* 将对象装换为map 
	* @param bean 
	* @return 
	*/  
	public static <T> Map<String, Object> beanToMap(T bean) {  
	  Map<String, Object> map = new HashMap<String, Object>();
	  if (bean != null) {  
	      BeanMap beanMap = BeanMap.create(bean);
	      for (Object key : beanMap.keySet()) {  
	          map.put(key+"", beanMap.get(key));  
	      }             
	  }  
	  return map;  
	}  
	
	/** 
	* 将map装换为javabean对象 
	* @param map 
	* @param bean 
	* @return 
	*/  
	public static <T> T mapToBean(Map<String, Object> map,T bean) {  
	  BeanMap beanMap = BeanMap.create(bean);
	  beanMap.putAll(map);  
	  return bean;  
	}  
	
	/** 
	* 将List<T>转换为List<Map<String, Object>> 
	* @param objList 
	* @return 
	*/
	public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {  
	  List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
	  if (objList != null && objList.size() > 0) {  
	      Map<String, Object> map = null;  
	      T bean = null;  
	      for (int i = 0,size = objList.size(); i < size; i++) {  
	          bean = objList.get(i);  
	          map = beanToMap(bean);  
	          list.add(map);  
	      }  
	  }  
	  return list;  
	}  
	
	/** 
	* 将List<Map<String,Object>>转换为List<T> 
	* @param maps 
	* @param clazz 
	* @return 
	* @throws InstantiationException 
	* @throws IllegalAccessException 
	*/  
	public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps,Class<T> clazz) throws InstantiationException, IllegalAccessException {  
	  List<T> list = new ArrayList<T>();  
	  if (maps != null && maps.size() > 0) {  
	      Map<String, Object> map = null;  
	      T bean = null;  
	      for (int i = 0,size = maps.size(); i < size; i++) {  
	          map = maps.get(i);  
	          bean = clazz.newInstance();  
	          mapToBean(map, bean);  
	          list.add(bean);  
	      }  
	  }  
	  return list;  
	}  
}

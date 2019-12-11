package spring.wechat.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class HttpUtils {
    /**
     * Log工具
     */
    private static final Log log                 = LogFactory.getLog(HttpUtils.class);
    /**
     * 连接超时时间
     */
    private static int       CONNECTION_TIME_OUT = 5000;
    /**
     * 等待超时时间
     */
    private static int       READ_TIME_OUT       = 30000;

    /**
     * 通过URL、方法、参数 、编码 获得服务端反回的字符串
     *
     * @param url URL
     * @param method 方法（GET，POST）
     * @param params 参数
     * @return 响应参数
     */
    public static String openUrl(String url, String method, Map<String, String> params,
                                 String enc) {

        String response = null;

        if (method.equals("GET")) {
            url = url + "?" + encodeUrl(params);
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setReadTimeout(50000); // 设置超时时间
            if (method.equals("POST")) {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.getOutputStream().write(encodeUrl(params).getBytes("UTF-8"));
            }
            response = read(conn.getInputStream(), enc);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return response;
    }

    /**
     * 根据URL和Json字符串请求
     * @param urlStr 请求url
     * @param jsonString 请求参数
     * @return 响应json
     * @throws IOException
     */
    public static String queryJsonData(String urlStr, String jsonString) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.connect();
        // POST请求
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(jsonString);
        out.flush();
        out.close();

        String str = read(connection.getInputStream(), "utf8");

        // 断开连接
        connection.disconnect();
        return str;
    }

    /**
     * 将类转换为json对象并发送POST请求，并封装成类返回
     * @param req 请求类
     * @param urlParam URL参数
     * @param type 类型
     * @param url URL
     * @param <T> 请求类
     * @param <M> 返回类
     * @throws IOException
     */
    public static <T, M> M httpPost(T req, String urlParam, Class<M> type,
                                    String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(req);
            log.info("trade asyn request param:" + jsonStr);
        } catch (JsonParseException e) {
            log.error("json解析错误：{}", e);
        }

        if (jsonStr != null) {
            String rtnString = null;
            // String url = null;
            StringBuilder sb = new StringBuilder();
            sb.append(url);
            if (urlParam != null) {
                sb.append("/");
                sb.append(urlParam);
            }
            url = sb.toString();

            rtnString = HttpUtils.queryJsonData(url, jsonStr);
            if (log.isInfoEnabled()) {
                log.info(rtnString);
            }

            M resp = mapper.readValue(rtnString, type);
            return resp;
        }

        return null;
    }

    /**
     * 将类转换为json对象并发送POST请求，并封装成类返回
     * @param req 请求类
     * @param urlParam URL参数
     * @param type 类型
     * @param url URL
     * @param <T> 请求类
     * @param <M> 返回类
     * @throws IOException
     */
    public static <T, M> M jsonForHttpPost(T req, String urlParam, Class<M> type,
                                           String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(req);
            log.info("trade asyn request param:" + jsonStr);
        } catch (JsonParseException e) {
            log.error("json解析错误：{}", e);
        }

        if (jsonStr != null) {
            String rtnString = null;
            // String url = null;
            StringBuilder sb = new StringBuilder();
            sb.append(url);
            if (urlParam != null) {
                sb.append("/");
                sb.append(urlParam);
            }
            url = sb.toString();

            rtnString = HttpUtils.queryJsonData(url, jsonStr);
            if (log.isInfoEnabled()) {
                log.info(rtnString);
            }

            M resp = mapper.readValue(rtnString, type);
            return resp;
        }

        return null;
    }

    /**
     * 将InputStream按一定编码读成字符串
     *
     * @param in  in
     * @param enc enc
     * @return String
     * @throws IOException
     */
    private static String read(InputStream in, String enc) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = null;
        if (enc != null) {
            // 按指定的编码读入流
            r = new BufferedReader(new InputStreamReader(in, enc), 1000);
        } else {
            // 按默认的编码读入
            r = new BufferedReader(new InputStreamReader(in), 1000);
        }

        for (String line = r.readLine(); line != null; line = r.readLine()) {
            sb.append(line);
        }
        in.close();
        return sb.toString();
    }

    /**
     * 将HashMap parameters类型的参数封闭到URL中
     *
     * @param hm hm
     * @return String
     */
    public static String encodeUrl(Map<String, String> hm) {
        if (hm == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        Iterator<String> it = hm.keySet().iterator();
        while (it.hasNext()) {
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            String key = it.next();
            sb.append(key + "=" + hm.get(key));
        }
        return sb.toString();
    }

    /**
     * 将类序列化为Json字符串
     * @param req req
     * @return String
     */
    public static String standardOrderJSON(Object req) {
        if (null == req) {
            return null;
        }
        String jsonStr = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 针对空beans也放过序列化
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            jsonStr = mapper.writeValueAsString(req);
        } catch (JsonParseException e) {
            log.error("json解析异常:{}", e);
        } catch (Exception e) {
            log.error("json解析异常:{}", e);
        }
        return jsonStr;
    }

    /**
     * 获取没有签名字段类的Json字符串
     * @param req req
     * @return String
     */
    public static String getNoSignJsonStr(Object req) {
        String jsonStr = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 针对空beans也放过序列化
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            jsonStr = mapper.writeValueAsString(req);
            JsonNode readTree = mapper.readTree(jsonStr);
            ObjectNode onode = (ObjectNode) readTree;
            onode.remove("sign");
            jsonStr = onode.toString();

        } catch (JsonParseException e) {
            log.error("json解析异常", e);
        } catch (IOException e) {
            log.error("json解析异常", e);
        }
        return jsonStr;
    }

    /**
     * http请求
     * @param requrl URL
     * @param params 参数
     * @return String
     * @throws Exception
     */
    public static String requestHTTP(String requrl, String params) throws Exception {
        try {
            URL url = new URL(requrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(CONNECTION_TIME_OUT);
            conn.setReadTimeout(READ_TIME_OUT);
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Length", Integer.toString(params.length()));

            OutputStreamWriter outputSW = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            outputSW.write(params);
            outputSW.flush();
            outputSW.close();

            log.debug("ResponseCode:" + conn.getResponseCode());
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String line;
            StringBuffer buffer = new StringBuffer(1024);
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            in.close();
            reader.close();
            return buffer.toString();
        } catch (IOException e) {
            log.error("调用地址:" + requrl);
            log.error("调用外部服务IO异常:{}" , e);
            throw e;
        } catch (Exception e) {
            log.error("其他错误:{}" , e);
            throw e;
        }
    }

    /**
     * HTTPS调用接口服务
     *
     * @param action action
     * @param params 参数
     * @throws IOException
     * @return String
     */
    public static String requestHTTPS(String urlStr, String action,
                                      String params) throws IOException {
        URL url = new URL(urlStr);
        HttpsURLConnectionImpl conn = (HttpsURLConnectionImpl) url.openConnection();
        conn.setConnectTimeout(CONNECTION_TIME_OUT);
        conn.setReadTimeout(READ_TIME_OUT);
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Length", Integer.toString(params.length()));
        if (!StringUtils.isEmpty(action)) {
            conn.setRequestProperty("SOAPAction", action);
        }
        OutputStreamWriter outputSW = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
        outputSW.write(params);
        outputSW.flush();
        outputSW.close();

        InputStream in = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
        String line;
        StringBuffer buffer = new StringBuffer(1024);
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        in.close();
        reader.close();
        return buffer.toString();
    }

    /**
     * 判断http或htts请求并处理
     *
     * @param url    请求URL
     * @param action action
     * @param params 请求参数
     * @return 响应信息
     */
    public static String httpRequest(String url, String action, String params) throws Exception {
        if (url != null && url.toLowerCase().startsWith("http:")) {
            return HttpUtils.requestHTTP(url, params);
        } else if (url != null && url.toLowerCase().startsWith("https:")) {
            return HttpUtils.requestHTTPS(url, action, params);
        } else {
            log.info("URL不正确,url:{}" + url);
            return null;
        }
    }
}

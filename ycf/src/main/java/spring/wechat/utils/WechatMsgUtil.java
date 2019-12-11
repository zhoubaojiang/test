package spring.wechat.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.*;


/**
 * 微信消息工具类
 * Created by 欧航 on 2017/6/29.
 */
public class WechatMsgUtil {
    private static Logger logger = LoggerFactory.getLogger(WechatMsgUtil.class);

    /**
     * 授权url构建类
     * @param baseUrl
     * @return
     */
    public static WechatOAuthUrl constructOAuthUrl(String baseUrl) {
        return new WechatOAuthUrl(baseUrl);
    }


    /**
     * 获取随机数
     * @return
     */
    public static String getNonceStr() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * 获取支付请求签名参数
     * @param params 键值ASIIC排序请求参数map
     * @param mchKey 商户密钥
     * @param encoding 字符编码
     * @return
     * @throws Exception
     */
    public static String getSignKey(SortedMap<String, Object> params, String mchKey, String encoding) throws Exception {
        StringBuilder sb = new StringBuilder();

        Set<Map.Entry<String, Object>> es = params.entrySet();//所有参与传参的参数按照accsii排序（升序）

        for (Map.Entry<String, Object> entry : es) {
            String k = entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }

        sb.append("key=").append(mchKey);


        return MD5Util.MD5(sb.toString(), encoding).toUpperCase();
    }

    /**
     * map 转 XML文本数据
     * @param map
     * @return
     */
    public static String Map2XML(Map<String, Object> map) {
        StringBuilder xml = new StringBuilder("<xml>\n");

        for (Map.Entry entry : map.entrySet()) {
            xml.append("  <").append(entry.getKey()).append(">")
                    .append(entry.getValue())
                    .append("</").append(entry.getKey()).append(">\n");
        }

        return xml.append("</xml>\n").toString();
    }

    /**
     * XML 文本数据转 map
     * @param xml
     * @return
     * @throws Exception
     */
    public static Map<String, Object> XML2Map(String xml) throws Exception {
        Map<String, Object> map = new HashMap<>();

        SAXReader reader = new SAXReader();
        InputStream ins = new ByteArrayInputStream(xml.getBytes());

        Document doc = reader.read(ins);
        Element root = doc.getRootElement();

        @SuppressWarnings("unchecked")
        List<Element> list = root.elements();
        for (Element e : list) {
            map.put(e.getName(), filterCDData(e.getText()));
        }

        ins.close();

        return map;
    }

    /**
     * 过滤 CDATA 免 xml 转换标签
     * @param str
     * @return
     */
    private static String filterCDData(String str) {

        if (str.startsWith("<![CDATA[")) {
            return str.replace("<![CDATA[", "").replace("]]", "");
        }

        return str;
    }

    /**
     * 微信授权 url 构建器
     */
    public static class WechatOAuthUrl {
        private StringBuilder baseUrl;

        WechatOAuthUrl(String baseUrl) {
            this.baseUrl = new StringBuilder(baseUrl);
            if (!baseUrl.endsWith("?")) {
                this.baseUrl.append("?");
            }
        }

        public WechatOAuthUrl appId(String appId) {
            this.baseUrl.append("appid=").append(appId).append("&");
            return this;
        }

        public WechatOAuthUrl secret(String secret) {
            this.baseUrl.append("secret=").append(secret).append("&");
            return this;
        }

        public WechatOAuthUrl code(String code) {
            this.baseUrl.append("code=").append(code).append("&");
            return this;
        }

        public WechatOAuthUrl openId(String openId) {
            this.baseUrl.append("openid=").append(openId).append("&");
            return this;
        }

        public WechatOAuthUrl lang(String lang) {
            this.baseUrl.append("lang=").append(lang).append("&");
            return this;
        }

        public WechatOAuthUrl accessToken(String accessToken) {
            this.baseUrl.append("access_token=").append(accessToken).append("&");
            return this;
        }

        public WechatOAuthUrl grantType(String grantType) {
            this.baseUrl.append("grant_type=").append(grantType).append("&");
            return this;
        }

        public WechatOAuthUrl redirectUrl(String redirectUri) {
            String urlEncodeed = null;

            try {
                urlEncodeed = URLEncoder.encode(redirectUri,"UTF-8");
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }

            this.baseUrl.append("redirect_uri=").append(urlEncodeed).append("&");
            return this;
        }

        public WechatOAuthUrl responseType(String responseType) {
            this.baseUrl.append("response_type=").append(responseType).append("&");
            return this;
        }

        public WechatOAuthUrl scope(String scope) {
            this.baseUrl.append("scope=").append(scope).append("&");
            return this;
        }

        public WechatOAuthUrl state(String state) {
            this.baseUrl.append("state=").append(state).append("&");
            return this;
        }

        public WechatOAuthUrl connectRedirect(String connectRedirect) {
            this.baseUrl.append("connect_redirect=").append(connectRedirect).append("&");
            return this;
        }

        public WechatOAuthUrl custParam(String paramName, String value) {
            this.baseUrl.append(paramName).append("=").append(value).append("&");
            return this;
        }

        public String build() {
            String result = this.baseUrl.toString();

            if (result.endsWith("&")) {
                result = result.substring(0, result.length()-1);
            }

            return result;
        }
    }
    
    /**
     * map 转 XML文本数据
     *
     * @param map
     * @return
     */
    public static String Map2XML(Map<String, Object> map, boolean needTranferCharsewt) {
        StringBuilder xml = new StringBuilder("<xml>\n");

        for (Map.Entry entry : map.entrySet()) {
            xml.append("  <").append(entry.getKey()).append(">")
                    .append(entry.getValue())
                    .append("</").append(entry.getKey()).append(">\n");
        }

        String res = xml.append("</xml>\n").toString();

        if (needTranferCharsewt) {
            try {
                res = new String (res.getBytes("UTF-8"), "ISO-8859-1");
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }

        return res;
    }
}

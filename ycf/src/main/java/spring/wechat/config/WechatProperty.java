package spring.wechat.config;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信支付配置类
 * Created by 欧航 on 2017/8/9.
 */
@Component
//@ConfigurationProperties(prefix = "wechat")
public class WechatProperty {

    /**
     * 设置微信公众号的appid
     */
    @Value("${wechat.appId}")
    private String appId;

    /**
     * 设置微信公众号的app secret
     */
    @Value("${wechat.secret}")
    private String secret;

    /**
     * 设置微信公众号的token
     */
    private String token;

    /**
     * 微信网页授权url
     */
    private String OAuthUrl;

    /**
     * 获取openID的url
     */
    @Value("${wechatOAuthOpenIdUrl}")
    private String OAuthOpenIdUrl;

    /**
     * 商户号
     */
    @Value("${wechat.mchId}")
    private String mchId;

    /**
     * 商户密钥
     */
    @Value("${wechat.mchKey}")
    private String mchKey;

    /**
     * 预订单回调接口
     */
    private String notifyUrl;
    
    /**
     * 商户证书路径
     */
    private String certPath;

    
    public String getCertPath() {
		return certPath;
	}

	public void setCertPath(String certPath) {
		this.certPath = certPath;
	}

	public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOAuthUrl() {
        return OAuthUrl;
    }

    public void setOAuthUrl(String OAuthUrl) {
        this.OAuthUrl = OAuthUrl;
    }

    public String getOAuthOpenIdUrl() {
        return OAuthOpenIdUrl;
    }

    public void setOAuthOpenIdUrl(String OAuthOpenIdUrl) {
        this.OAuthOpenIdUrl = OAuthOpenIdUrl;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

}

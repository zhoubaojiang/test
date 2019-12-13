package spring.wechat.api;

import spring.wechat.config.WechatProperty;
import spring.wechat.exception.BusinessException;
import spring.wechat.vo.OpenIdResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

@Component
public class WechatAPI {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WechatProperty wechatProperty;

    /**
     * 获取用户openid
     * @param code
     * @return
     * @throws Exception
     */
	public String getOpenId(String code) throws Exception{
		String result = "";
		logger.info("/openid start....");
		String appid = wechatProperty.getAppId();
		String secret = wechatProperty.getSecret();

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/sns/jscode2session?" + "appid=" + appid + "&secret="
				+ secret + "&js_code=" + code + "&grant_type=authorization_code");
		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
			logger.info(response.getStatusLine().toString());
			String resp = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
			OpenIdResponse or = new ObjectMapper().readValue(resp, OpenIdResponse.class);
			if(!StringUtils.isEmpty(or.getErrcode())) {
				logger.info("获取微信openid异常:" + or.getErrmsg());
				logger.info("获取微信openid异常:" + or.getErrcode());
				throw new BusinessException("获取微信openid异常");
			}
			result = or.getOpenid();
			logger.info("获取微信openid" + result);
		}catch (BusinessException e) {
			throw new BusinessException(e.getErrorMsg());
		} catch (Exception e) {
			logger.info("获取微信openid网络异常");
			throw new BusinessException("网络异常");
		}
		return result;
	}
}

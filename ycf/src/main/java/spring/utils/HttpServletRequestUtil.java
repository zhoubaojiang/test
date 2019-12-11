package spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import static spring.utils.Constants.*;

/**
 * HttpServletRequest获取对应对象
 */
@Service
public class HttpServletRequestUtil {

    @Autowired
    private HttpServletRequest requests;


    public String getToken() {
        return requests.getHeader(HEADER_TOKEN);
    }

    public String getTimestamp() {
        return requests.getHeader(HEADER_TIMESTAMP);
    }

    public String getRequestId() {
        return requests.getHeader(HEADER_REQUESTID);
    }

    public String getLoginId() {
        return requests.getHeader(HEADER_LOGINID);
    }

    public String getSign() {
        return requests.getHeader(HEADER_SIGN);
    }

    public String getChannelId() {
        return requests.getHeader(HEADER_CHANNELID);
    }

    public String getUserType() {
        return requests.getHeader(HEADER_USER_TYPE);
    }

    /**
     *
     * 功能描述: 获取当前登录用户(后台管理员，商家，代理商，会员）对应的用户ID<br>
     * @author: wenwj
     * @date: 2018年8月23日 下午5:55:03
     * @version 1.8.1
     * @return
     */
    public Long getCurrentLoginUserId(){
    	return UserInfoRedisUtil.getUserId(this.getLoginId(), this.getUserType(), this.getChannelId());
    }

    /**
     *
     * 功能描述: 获取当前登录用户(后台管理员，商家，代理商，会员）账号<br>
     * @author: wenwj
     * @date: 2018年8月23日 下午5:56:47
     * @version 1.8.1
     * @return
     */
    public String getCurrentLoginUserAccount(){
    	return UserInfoRedisUtil.getLoginAccount(this.getLoginId(), this.getUserType(), this.getChannelId());
    }

    /**
     *
     * 功能描述: 获取当前登录用户(后台管理员，商家，代理商，会员）名字<br>
     * @author: wenwj
     * @date: 2018年8月23日 下午5:54:24
     * @version 1.8.1
     * @return
     */
    public String getCurrentLoginUserName(){
    	return UserInfoRedisUtil.getUserName(this.getLoginId(), this.getUserType(), this.getChannelId());
    }


}

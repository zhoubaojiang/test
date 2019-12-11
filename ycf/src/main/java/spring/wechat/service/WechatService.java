package spring.wechat.service;

public interface WechatService {
    /**
     * 获取微信open_id
     * @param code
     * @return
     */
    String getOpenid(String code) throws Exception ;
}

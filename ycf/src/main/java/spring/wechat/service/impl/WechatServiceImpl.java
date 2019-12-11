package spring.wechat.service.impl;

import spring.wechat.api.WechatAPI;
import spring.wechat.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WechatServiceImpl implements WechatService {
    @Autowired
    private WechatAPI wechatAPI;

    @Override
    public String getOpenid(String code) throws Exception {
        return wechatAPI.getOpenId(code);
    }
}

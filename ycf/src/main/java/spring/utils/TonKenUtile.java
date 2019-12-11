package spring.utils;

import spring.dto.request.UserLoginDto;
import spring.dto.result.UserLoginResponse;
import spring.model.MUserManual;

import java.util.UUID;

public class TonKenUtile {
    /**
     * @param result   登录返回类
     * @param loginDto 登录请求类
     * @return
     * @Description: 设置返回值token
     * @author wangdg
     * @date 2018/8/21 13:59
     */
    public static void setResultToken(UserLoginResponse result, UserLoginDto loginDto, MUserManual member) {
        String loginId = member.getWfcode();
        String channelId = loginDto.getChannelId();
        String userType = loginDto.getUserType();
        String token = UUID.randomUUID().toString();
        result.setToken(token);
        // 获取旧token
        if (UserInfoRedisUtil.existsCache(loginId, userType, channelId)) {
            UserLoginResponse userInfo = UserInfoRedisUtil.getUserCache(loginId, userType, channelId);
            if (userInfo != null) {
                String oldToken = userInfo.getOldToken();
                result.setOldToken(oldToken);
            }
        }
    }

    /**
     * 登出删除缓存
     *
     * @param channelId 登录渠道
     * @param userType 用户类型
     * @param userId 用户ID
     * @return
     */
    public static void loginOut(String userId, String userType, String channelId) {
        UserInfoRedisUtil.deleteUserCache(userId, userType, channelId);
    }
}

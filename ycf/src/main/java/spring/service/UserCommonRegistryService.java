package spring.service;

import spring.dto.BaseCommonResult;
import spring.dto.request.UserAccountRequest;
import spring.dto.request.UserLoginDto;
import spring.dto.result.UserLoginResponse;

/**
 * 后台管理员注册接口
 *
 */
public interface UserCommonRegistryService {

    BaseCommonResult createAccount(UserAccountRequest request);

    BaseCommonResult<UserLoginResponse> userLogin(UserLoginDto loginDto);

    BaseCommonResult updateAccount(UserAccountRequest request);

    BaseCommonResult<UserLoginResponse> userLogout(UserLoginDto loginDto);
}

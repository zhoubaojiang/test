package spring.utils.alioss;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spring.utils.Constants;

/**
 * @author wangdg
 * @Description: RAM
 * @date 2017/7/25 18:17
 */

public class OSSStsAuth {

	private static final Logger logger = LoggerFactory.getLogger(OSSStsAuth.class);

	// 目前只有"cn-hangzhou"这个region可用, 不要使用填写其他region的值
	private String regionCnHangZhou;
	// 当前 STS API 版本
	private String stsApiVersion;
	private String accessKeyId;
	private String accessKeySecret;
	private String roleArn;
	private String roleSessionName;
	private String policy;

	public OSSStsAuth(String regionCnHangZhou, String stsApiVersion, String accessKeyId, String accessKeySecret, String roleArn,
			String roleSessionName, String policy) {
		this.regionCnHangZhou = regionCnHangZhou;
		this.stsApiVersion = stsApiVersion;
		this.accessKeyId = accessKeyId;
		this.accessKeySecret = accessKeySecret;
		this.roleArn = roleArn;
		this.roleSessionName = roleSessionName;
		this.policy = policy;
	}

	public AssumeRoleResponse assumeRole()  {
		AssumeRoleResponse response = null;
		try {
			// 创建一个 Aliyun Acs Client, 用于发起 OpenAPI 请求
			IClientProfile profile = DefaultProfile.getProfile(regionCnHangZhou, accessKeyId, accessKeySecret);
			DefaultAcsClient client = new DefaultAcsClient(profile);
			// 创建一个 AssumeRoleRequest 并设置请求参数
			final AssumeRoleRequest request = new AssumeRoleRequest();
			// 此处必须为 HTTPS
			ProtocolType protocolType = ProtocolType.HTTPS;
			request.setVersion(stsApiVersion);
			request.setMethod(MethodType.POST);
			request.setProtocol(protocolType);
			request.setRoleArn(roleArn);
			request.setRoleSessionName(roleSessionName);
			request.setPolicy(policy);
			request.setDurationSeconds(Constants.MEMBER_OSS_STS_OVERTIME);// 凭证过期时间
			// 发起请求，并得到response
			response = client.getAcsResponse(request);
		} catch (Exception e) {
			logger.error(" assumeRole () is failture~~ ");
		}
		return response;
	}

}

package spring.utils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author wangdg
 * @ClassName: GenerateCodeUtil
 * @Description: 验证码工具类
 * @date 2017/6/13 19:28
 */
public class GenerateCodeUtil {
	private GenerateCodeUtil() {
	}

	private static GenerateCodeUtil instance = new GenerateCodeUtil();

	public static GenerateCodeUtil getInstance() {
		return instance;
	}

	private static final String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	/**
	 * 生成验证码
	 * @param count 验证码长度
	 * @param flag true: 包括字母的验证码 false: 纯数字的验证码
	 * @return
	 */
	public static String getVerificationCode(Integer count, boolean flag) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		String baseNumber = "0123456789";
		if (count <= 0 && flag) {
			return base;
		} else if (count <= 0 && !flag) {
			return baseNumber;
		}
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		// 转为纯数字
		if (!flag) {
			base = baseNumber;
		}
		for (int i = 0; i < count; i++) {

			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 是否操作10钟有效期
	 *
	 * @param createDate 验证码创建时间
	 * @return true: 超时 false:没有超时
	 */
	public static boolean codeIsOverTime(Date createDate) {
		Date currentDate = new Date();
		boolean isOverTime = false;
		if (currentDate.getTime() - createDate.getTime() > 10 * 60 * 1000) {
			isOverTime = true;
			return isOverTime;
		}
		return isOverTime;
	}

	/**
	 *  是否超过指定时间间隔
	 * @param timestamp     要与当前时间比较的时间戳
	 * @return              true: 超时   false: 未超时
	 */
	public static boolean codeIsOverTime(long timestamp, int minute) {
		Date current = new Date();
		boolean isOverTime = false;
		if (current.getTime() - timestamp > minute * 60 * 1000) {
			isOverTime = true;
			return isOverTime;
		}
		return isOverTime;
	}

	/**
	 *  生成8位的邀请码
	 * @return 返回8位邀请码
	 *
	 */
	public static String generateEightCode() {
		StringBuilder shortBuffer = new StringBuilder();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString().toLowerCase();
	}

	/**
	 *  生成6位的邀请码
	 * @return 返回6位邀请码
	 */
	public static String generateSixCode() {
		return generateEightCode().substring(2);
	}

}

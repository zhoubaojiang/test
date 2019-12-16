package spring.utils.alioss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.event.ProgressListener;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author wangdg
 * @ClassName:  OSSClientUtil
 * @Description: 阿里云OSS工具类
 * @date 2017/6/22 10:44
 */
@Component
public class OSSClientUtil {
	private static final Logger logger = LoggerFactory.getLogger(OSSClientUtil.class);
	// oss节点
	private String endpoint;
	//访问key
	private String accessKeyId;
	//访问密匙
	private String accessKeySecret;
	// 空间
	private String bucketName;
	//图片访问域名
	private String url;
	/**
	 * 初始化参数数据
	 * @param endpoint
	 * @param accessKeyId
	 * @param accessKeySecret
	 * @param bucketName
	 * @param url
	 */
	public OSSClientUtil(String endpoint,String accessKeyId,String  accessKeySecret,String bucketName,String url){
		this.endpoint=endpoint;
		this.accessKeyId=accessKeyId;
		this.accessKeySecret=accessKeySecret;
		this.bucketName=bucketName;
		this.url=url;
	}

	public OSSClientUtil() {
	}


	/**
	 *  文件上传到阿里oss
	 * @param inputStream        需要上传的图片
	 * @param originalFilename   原始文件的名称
	 * @param filedir   		 上传图片在oss的路径
	 * @return					 返回需要保存到数据库的url    /member/header1498136383407.png
	 * @throws IOException 
	 */
	public String uploadImg(InputStream inputStream, String originalFilename, String filedir) throws IOException {
		String fileName = this.uploadImg2Oss(inputStream, originalFilename, filedir); // 上传图片
		 String imgUrl = this.getImgUrl(fileName,filedir);// 获取url
		 logger.info("上传图片的url:{}",imgUrl);
//		 String subString = splitFileUrl(imgUrl); // 保存到数据库的url
//		return "/" + filedir + fileName;
		return imgUrl;
	}

	/**
	 *  需要保存到数据库的url截取
	 * @param fileUrl   需要截取的路径  http://javawufu.oss-cn-shenzhen.aliyuncs.com/member/header1498136383407.png...
	 * @return          返回截取后的路径  /member/header1498136383407.png...
	 */
	public String splitFileUrl(String fileUrl) {
		if(StringUtils.isBlank(fileUrl)){
			logger.error("fileUrl为空或者空字符串:{}",fileUrl);
			return "";
		}
		int index = fileUrl.indexOf(".com");
		if (-1==index){ //若不用截取
			return fileUrl;
		}
		String substring = fileUrl.substring(index + 4);
		return substring;
	}

	/**
	 *  多图片字符url处理
	 * @param multiFile		多个图片url的数组
	 * @return				需要保存到数据库中的图片数组
	 */
	public String splitMultiFileUrl(List<String> multiFile){
		if(multiFile.isEmpty()){
			return "";
		}
		List<String> splitList = multiFile.stream().map(s -> splitFileUrl(s)).collect(Collectors.toList());
		logger.info("截取掉域名后台的集合:{}"+splitList);
		return splitList.toString();
	}

	/**
	 * 更具多url字符串生成url数组
	 * @param multiFile			多个url字符串
	 * @return					url字符串数组
	 */
	private  String[] str2StrArray(String multiFile){
		if(StringUtils.isBlank(multiFile)){
			return new String[]{};
		}
		if(multiFile.startsWith("[")){
			multiFile = multiFile.substring(1);
		}
		if(multiFile.endsWith("]")){
			multiFile = multiFile.substring(0, multiFile.length()-1);
		}
		return multiFile.split(", ");// 集合会用空格隔开元素
	}
	/**
	 *  给多文件url添加域名
	 * @param multiFile			多个url字符串
	 * @return
	 */
	public List<String> addCom2Url(String multiFile){
		String[] fileArray = str2StrArray(multiFile);
		List<String> list = new ArrayList<>();
		for (String file : fileArray) {
			list.add(url+file);
		}
		logger.info("拼接的url字符数组:{}",list);
		return list;
	}
	/**
	 * 上传本地文件
	 * @param url 本地文件路径
	 * @param filedir 保存到OSS的文件路径
	 * @throws IOException 
	 */
	public void uploadImg2Oss(String url, String filedir) throws IOException {
		File fileOnServer = new File(url);
		FileInputStream fin;
		fin = new FileInputStream(fileOnServer);
		String[] split = url.split("/");
		this.uploadFile2OSS(fin, split[split.length - 1], filedir);
	}

	/**
	 *  上传web前端传输的文件
	 * @param inputStream    	 要上传的文件
	 * @param originalFilename   原始文件的名称
	 * @param filedir 		 	 文件的路径        例: member/header/
	 * @return        		 	 返回上传图片的名字  例: 1499087092395.jpg
	 * @throws IOException 
	 */
	public String uploadImg2Oss(InputStream inputStream, String originalFilename, String filedir) throws IOException {
		String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		Random random = new Random();
		String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
		this.uploadFile2OSS(inputStream, name, filedir);
		return name;
	}

	/**
	 * 根据 路径+文件名 获得完整图片url
	 *
	 * @param fileName 上传名    1499087092395.jpg
	 * @param filedir 上传文件路径  member/header/
	 * @return        返回文件url地址
	 *  例: http://javawufu.oss-cn-shenzhen.aliyuncs.com/member/header/1499087092395.jpg?Expires=1814447271&OSSAccessKeyId=r73eBVPWkSpc79oq&Signature=MFQkEwiLO5ZkM3e9%2B6yP03WxGGk%3D
	 */
	public String getImgUrl(String fileName, String filedir) {
		if (StringUtils.isNotBlank(fileName)) {
			String[] split = fileName.split("/");
			return this.getUrl(filedir + split[split.length - 1],1440);
		}
		return null;
	}

	/**
	 * 上传到OSS服务器  如果同名文件会覆盖服务器上的
	 *
	 * @param instream 文件流
	 * @param fileName 文件名称 包括后缀名
	 * @param filedir  文件保存的路径
	 * @return 出错返回"" ,唯一MD5数字签名
	 * @throws IOException 
	 */
	public String uploadFile2OSS(InputStream instream, String fileName, String filedir) throws IOException {
		String ret = "";
		OSSClient client = null;
		try {
			// 创建上传Object的Metadata
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(instream.available());
			objectMetadata.setCacheControl("no-cache");
			objectMetadata.setHeader("Pragma", "no-cache");
			objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
			objectMetadata.setContentDisposition("inline;filename=" + fileName);
			// 上传文件
			client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			PutObjectResult putResult = client.putObject(bucketName, filedir + fileName, instream, objectMetadata);
			
			ret = putResult.getETag();
		} catch (IOException e) {
			logger.error("上传图片失败:{}", e.getMessage(), e);
			throw e;
		} finally {
			try {
				if (instream != null) {
					instream.close();
				}
				if(client != null){
					client.shutdown();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	/**
	 * 上传到OSS服务器  如果同名文件会覆盖服务器上的
	 *
	 * @param instream 文件流
	 * @param fileName 文件名称 包括后缀名
	 * @param filedir  文件保存的路径
	 * @return 出错返回"" ,唯一MD5数字签名
	 * @throws IOException 
	 */
	public String uploadFile2OSS(InputStream instream, String objectName) throws IOException {
		String ret = "";
		OSSClient client = null;
		try {
			// 上传文件
			client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			PutObjectResult putResult = client.putObject(bucketName, objectName, instream);
			
			ret = putResult.getETag();
		} finally {
			try {
				if (instream != null) {
					instream.close();
				}
				if(client != null){
					client.shutdown();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	/**
	 * 
	* 功能描述: OSS服务器下载文件
	* @author: xiongkun
	* @date: 2018年12月20日 上午9:00:39 
	* @param objectName  文件流
	* @param localFileName  文件名称 包括后缀名
	* @return  出错返回"" ,唯一MD5数字签名
	* @throws IOException
	 */
	public File downloadFile2OSS(String objectName, String localFileName) throws IOException {
		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		File file = new File(localFileName);
		// ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
		//client.getObject(new GetObjectRequest(bucketName, objectName), file);
		OSSObject ossObject = client.getObject(bucketName, objectName);
		ossObject.getObjectContent();
		// 关闭OSSClient。
		client.shutdown();
		return file;
	}
	
	public InputStream downloadFile2OSS(String objectName) throws IOException {
		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
		//client.getObject(new GetObjectRequest(bucketName, objectName), file);
		OSSObject ossObject = client.getObject(bucketName, objectName);
		InputStream is = ossObject.getObjectContent();
		// 关闭OSSClient。
		//client.shutdown();
		return is;
	}

	/**
	 * Description: 判断OSS服务文件上传时文件的contentType
	 *
	 * @param FilenameExtension 文件后缀
	 * @return String
	 */
	public static String getcontentType(String FilenameExtension) {
		if (FilenameExtension.equalsIgnoreCase(".bmp")) {
			return "image/bmp";
		}
		if (FilenameExtension.equalsIgnoreCase(".gif")) {
			return "image/gif";
		}
		if (FilenameExtension.equalsIgnoreCase(".jpeg") || FilenameExtension.equalsIgnoreCase(".jpg")
				|| FilenameExtension.equalsIgnoreCase(".png")) {
			return "image/jpeg";
		}
		if (FilenameExtension.equalsIgnoreCase(".html")) {
			return "text/html";
		}
		if (FilenameExtension.equalsIgnoreCase(".txt")) {
			return "text/plain";
		}
		if (FilenameExtension.equalsIgnoreCase(".vsd")) {
			return "application/vnd.visio";
		}
		if (FilenameExtension.equalsIgnoreCase(".pptx") || FilenameExtension.equalsIgnoreCase(".ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		if (FilenameExtension.equalsIgnoreCase(".docx") || FilenameExtension.equalsIgnoreCase(".doc")) {
			return "application/msword";
		}
		if (FilenameExtension.equalsIgnoreCase(".xml")) {
			return "text/xml";
		}
		if (FilenameExtension.equalsIgnoreCase(".pdf")) {
			return "application/pdf";
		}
		return "image/jpeg";
	}

	/**
	 * 获得完整url链接
	 * @param key 				文件路径  例: member/header/1499087904409.png
	 * @param overTime          url失效时间  单位: 分钟
	 * @return   				返回文件的url
	 * 例: http://javawufu.oss-cn-shenzhen.aliyuncs.com/member/header/1499087904409.png?Expires=1814447948&OSSAccessKeyId=r73eBVPWkSpc79oq&Signature=SyA997L62%2F0HpYOshHygbb5Ryv0%3D
	 */
	public String getUrl(String key, int overTime) {
		// 设置URL过期时间
		Date expiration = new Date(new Date().getTime() + overTime * 60 * 1000);
		// 生成URL
		OSSClient client= new OSSClient(endpoint, accessKeyId, accessKeySecret);
		URL url = client.generatePresignedUrl(bucketName, key, expiration);
		if (url != null) {
			return url.toString();
		}
		client.shutdown();
		return null;
	}

	/**
	 * 根据完整url删除图片
	 * @param fileUrl    保存到数据库的url http://javawufu.oss-cn-shenzhen.aliyuncs.com/member/header/1499087904409.png ...
	 * @return           true 删除成功
	 */
	public boolean delByUrl(String fileUrl) {
		int endIndex = fileUrl.indexOf("?");
		String substring = fileUrl.substring(1, endIndex); // member/header1498136383407.png...
		return this.deleteImg(substring);
	}

	/**
	 * 根据文件路径+文件名删除文件
	 * @param fileName 删除文件的 路径+文件名  member/header/1499153722838.jpg...
	 * @return true 删除成功
	 */
	public boolean deleteImg(String fileName) {
		OSSClient client = null;
		try {
			client= new OSSClient(endpoint, accessKeyId, accessKeySecret);
			// Object是否存在
			if (client.doesObjectExist(bucketName, fileName)) {
				client.deleteObject(bucketName, fileName);
			}
		} catch (Exception e) {
			logger.error("文件删除失败,异常信息:{}", e);
			throw e;
		} finally {
			if (client != null) {
				client.shutdown();
			}
		}
		return true;
	}
	
	/**
	 * 带进度上传文件方法
	 * */
	public String uploadProgress(InputStream inputStream, String originalFilename, String filedir, ProgressListener progress) throws IOException {
		String fileName = this.uploadProgressOss(inputStream, originalFilename, filedir, progress);
		return "/" + filedir + fileName;
	}
	/**
	 * 带进度上传文件方法处理生成文件名称
	 * */
	public String uploadProgressOss(InputStream inputStream, String originalFilename, String filedir, ProgressListener progress) throws IOException {
		String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		Random random = new Random();
		String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
		this.ossUploadFileProgress(inputStream, name, filedir, progress);
		return name;
	}
	
	/**
	 * 带进度上传文件调用OSS
	 * **/
	public void ossUploadFileProgress(InputStream instream, String fileName, String filedir, ProgressListener progress) {
		String objectName = filedir+fileName;
		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		try {
            // 带进度条的上传。
			client.putObject(new PutObjectRequest(bucketName, objectName, instream)
            		.<PutObjectRequest>withProgressListener(progress));
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 关闭OSSClient。
		client.shutdown();
	}
}

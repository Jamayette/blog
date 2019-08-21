package com.jamayette.util;

import cn.ucloud.ufile.UfileClient;
import cn.ucloud.ufile.api.object.ObjectConfig;
import cn.ucloud.ufile.auth.ObjectAuthorization;
import cn.ucloud.ufile.auth.UfileObjectLocalAuthorization;
import cn.ucloud.ufile.bean.PutObjectResultBean;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;


public class UploadUtil {

	private static String PUBLIC_KEY = "TOKEN_fcaabd36-9931-44c2-b5c7-c75877fb2da1";
	private static String PRIVATE_KEY = "a7c79767-1f4e-4df6-b40a-2ba854bca230";
	private static ObjectAuthorization OBJECT_AUTHORIZER = new UfileObjectLocalAuthorization(PUBLIC_KEY, PRIVATE_KEY);
	private static String BASE_URL = "http://jamayette.cn-sh2.ufileos.com/";

	public static String upload(MultipartFile file) throws Exception {

		String timeStamp = DateUtil.getTimeStamp();

		// 对象操作需要ObjectConfig来配置您的地区和域名后缀
		ObjectConfig config = new ObjectConfig("cn-sh2", "ufileos.com");

		File uploadFile = FileUtil.convertFile(file);

		try {
			PutObjectResultBean response = UfileClient.object(OBJECT_AUTHORIZER, config)
							.putObject(uploadFile, new MimetypesFileTypeMap().getContentType(uploadFile))
							.nameAs(timeStamp)
							.toBucket("jamayette")
							.execute();

			return BASE_URL + timeStamp;


		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

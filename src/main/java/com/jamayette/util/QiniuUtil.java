package com.jamayette.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class QiniuUtil {

	public static String QINIU_URL = "http://ozum2yyu0.bkt.clouddn.com/";

	private static String QINIU_ACCESSKEY = "Rbjlm-DXk7YgQNXT2jAorymTJY-BZzB_Maf0Zkd_";

	private static String QINIU_SECRETKEY = "pkNd9lDUmicacsQ0bWbM1qnBWSYsMIkoBiZjhvTZ";

	private static String QINIU_BUCKET = "blog";

	public static String upload(MultipartFile file) {

		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		//默认不指定key的情况下，以文件内容的hash值作为文件名
		String key = file.getOriginalFilename();

		try {

			byte[] uploadBytes = file.getBytes();

			//...生成上传凭证，然后准备上传
			Auth auth = Auth.create(QINIU_ACCESSKEY, QINIU_SECRETKEY);
			String upToken = auth.uploadToken(QINIU_BUCKET);

			try {
				Response response = uploadManager.put(uploadBytes, key, upToken);
				//解析上传成功的结果
				DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

				return putRet.key;

			} catch (QiniuException ex) {
				Response r = ex.response;
				System.err.println(r.toString());
				try {
					System.err.println(r.bodyString());
				} catch (QiniuException ex2) {
					//ignore
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String delete(String key) {

		if (key == null) {
			return null;
		}

		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());

		//...其他参数参考类注释
		Auth auth = Auth.create(QINIU_ACCESSKEY, QINIU_SECRETKEY);

		BucketManager bucketManager = new BucketManager(auth, cfg);

		try {
			if (key.contains("/")) {
				String[] split = key.split("/");
				key = split[split.length - 1];
			}
			bucketManager.delete(QINIU_BUCKET, key);
		} catch (QiniuException ex) {
			//如果遇到异常，说明删除失败
			System.err.println(ex.code());
			System.err.println(ex.response.toString());
		}

		return null;
	}

}

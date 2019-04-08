package com.jamayette.util;

import com.jamayette.model.Message;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SmsUtil {

	private static String DoSend(String postData) {

		try {

			//发送POST请求
			String POST_URL = "http://cf.51welink.com/submitdata/service.asmx/g_Submit";
			URL url = new URL(POST_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setUseCaches(false);
			conn.setDoOutput(true);

			conn.setRequestProperty("Content-Length", "" + postData.length());
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(postData);
			out.flush();
			out.close();

			//获取响应状态
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				return "connect failed!";
			}

			//获取响应内容体
			String line;
			StringBuilder result = new StringBuilder();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			while ((line = in.readLine()) != null) {
				result.append(line).append("\n");
			}
			in.close();

			return result.toString();

		} catch (IOException ignored) {

		}
		return "send failed";
	}

	public static boolean Send(Message message) throws UnsupportedEncodingException {

		String content = message.getContent() + "【" + message.getTag() + "】";

		String PostData = "sname=dlduozao&spwd=lovems2816231&scorpid=4671&sprdid=1012818&sdst=" + message.getPhoneNumber() + "&smsg=" + URLEncoder.encode(content, "utf-8");

		return DoSend(PostData).contains("提交成功");

	}

}
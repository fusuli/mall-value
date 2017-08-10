package org.fusu.mall.util;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
	private static OkHttpClient client = new OkHttpClient();

	public static String getString(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		try{
			Response response = client.newCall(request).execute();
			return response.body().string();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
}

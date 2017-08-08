package org.fusu.mall.value;

import java.io.IOException;

import org.fusu.mall.bean.ItemBean;
import org.fusu.mall.util.HttpUtil;
import org.fusu.mall.util.JsoupUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		String url = "https://shouji.jd.com/";
		try {
			String body = HttpUtil.getString(url);
			// 获取页面所有链接
			String metak = JsoupUtil.getAMetaK(body);
			ItemBean itemBean =JsoupUtil.getItemBean(body, url);
			System.out.println(itemBean);
		} catch (IOException e) {
			// TODO: handle exception
		}
	 }
}

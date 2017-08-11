package org.fusu.mall.value;

import java.io.IOException;
import java.util.List;

import org.fusu.mall.bean.ItemBean;
import org.fusu.mall.dao.IItemDao;
import org.fusu.mall.dao.IUrlDao;
import org.fusu.mall.dao.ItemDao;
import org.fusu.mall.dao.UrlDao;
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
			goUrls(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// do {
		//
		// } while (true);
	}

	private static void goUrls(String url) {
		try {
			String body = HttpUtil.getString(url);
			ItemBean itemBean = JsoupUtil.getItemBean(body, url);
			IItemDao itemDao = new ItemDao();
			itemDao.addItem(itemBean);

			List<String> list1 = JsoupUtil.getALink(body);
			IUrlDao urlDao = new UrlDao();
			urlDao.addUrl(list1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

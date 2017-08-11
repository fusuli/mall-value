package org.fusu.mall.value;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.fusu.mall.bean.ItemBean;
import org.fusu.mall.bean.UrlBean;
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
			go(url);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void go(String url) throws InterruptedException {
		goUrls(url);
		goItem(url);
		do {
			int i = 0;
			IUrlDao urlDao = new UrlDao();
			List<UrlBean> urlList = urlDao.getAllUrl();
			for (Iterator<UrlBean> it = urlList.iterator(); it.hasNext();) {
				UrlBean urlBean = (UrlBean) it.next();
				goItem(urlBean.getUrl());
				goUrls(urlBean.getUrl());
				i++;
				System.out.println(i);
				Thread.sleep(2000);
			}
		} while (true);
	}

	private static void goUrls(String url) {
		try {
			String body = HttpUtil.getString(url);
			List<String> list = JsoupUtil.getALink(body);
			IUrlDao urlDao = new UrlDao();
			urlDao.addUrl(list);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void goItem(String url) {
		String body;
		try {
			body = HttpUtil.getString(url);
			ItemBean itemBean = JsoupUtil.getItemBean(body, url);
			IItemDao itemDao = new ItemDao();
			itemDao.addItem(itemBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getAllUrl() {
		try {
			IUrlDao urlDao = new UrlDao();
			List<UrlBean> urlList = urlDao.getAllUrl();
			for (Iterator<UrlBean> it = urlList.iterator(); it.hasNext();) {
				UrlBean urlBean = (UrlBean) it.next();
				System.out.println(urlBean.getUrlid());
				System.out.println(urlBean.getUrl());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

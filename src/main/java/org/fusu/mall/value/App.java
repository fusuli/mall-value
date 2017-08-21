package org.fusu.mall.value;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
		String url = "https://shouji.jd.com";
		try {
			go(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void go(String url) throws InterruptedException {
		url = StringUtils.trim(url);
		goHtml(url);
		do {
			int i = 0;
			IUrlDao urlDao = new UrlDao();
			List<UrlBean> urlList = urlDao.getAllUrl();
			for (Iterator<UrlBean> it = urlList.iterator(); it.hasNext();) {
				UrlBean urlBean = (UrlBean) it.next();
				if (urlBean.getStatus() == 0) {
					goHtml(StringUtils.trim(urlBean.getUrl()));
					urlDao.updateUrlStatus(StringUtils.trim(urlBean.getUrl()));
				} else if (urlBean.getStatus() == 100) {
					System.err.println("URL has been accessed!!!");
					continue;
				}
				i++;
				System.out.println("Accessing article " + i + " URL ：" + urlBean.getUrl());
				Thread.sleep((long) (2000*Math.random()));
			}
		} while (true);
	}

	private static void goHtml(String url) {
		try {
			String body = HttpUtil.getString(url);
			List<String> list = JsoupUtil.getALink(body);
			IUrlDao urlDao = new UrlDao();
			urlDao.addUrl(list);
			
			ItemBean itemBean = JsoupUtil.getItemBean(body, url);
			IItemDao itemDao = new ItemDao();
			itemDao.addItem(itemBean);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

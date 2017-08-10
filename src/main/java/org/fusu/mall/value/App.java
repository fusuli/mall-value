package org.fusu.mall.value;

import java.io.IOException;
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
			 String body = HttpUtil.getString(url);
			 ItemBean itemBean = JsoupUtil.getItemBean(body, url);
			 IItemDao itemDao = new ItemDao();
			 itemDao.addItem(itemBean);
//			 List<String> list = JsoupUtil.getALink(body);
//			 System.out.println(list.size());
//			 for(int i=0;i<list.size();i++) {
//			 String alink = list.get(i);
//			 System.out.println(alink);
//			 }
			List<String> list1 = JsoupUtil.getALink(body);
			IUrlDao urlDao = new UrlDao();
			urlDao.addUrl(list1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

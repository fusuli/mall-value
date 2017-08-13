package org.fusu.mall.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.fusu.mall.bean.ItemBean;
import org.fusu.mall.bean.UrlBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author fusu
 *
 */
public class JsoupUtil {
	/**
	 * 根据html获得网页doc
	 * 
	 * @param html
	 * @return
	 */
	public static Document getDoc(String html) {
		Document doc = Jsoup.parse(html);
		return doc;
	}

	public static String getTitle(Document doc) {
		return doc.title();
	}

	/*
	 * 获取网页title
	 * 
	 * @param html
	 * 
	 * @return
	 */
	public static String getTitle(String html) {
		return getDoc(html).title();
	}

	/**
	 * 根据body获取页面内所有的链接
	 * 
	 * @param body
	 * @return
	 */
	public static List<String> getALink(String body) {
		List<String> list = new ArrayList<String>();
		Elements links = getDoc(body).select("a");
		for (Element link : links) {
			String href = link.attr("href");
			int index = href.indexOf("item.jd.com");
			if (index != -1) {
				int index2 = href.indexOf("https:");
				if (index2 == -1) {
					href = "https:" + href;
					list.add(href);
				}
				list.add(href);
			} else {
				continue;
			}
		}
		LinkedHashSet<String> set = new LinkedHashSet<String>(list);
		ArrayList<String> list2 = new ArrayList<String>(set);
		return list2;
	}

	/**
	 * 去除list中重复的元素
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> getLinkedHashSet(List<String> list) {
		LinkedHashSet<String> set = new LinkedHashSet<String>(list);
		ArrayList<String> list2 = new ArrayList<String>(set);
		return list2;
	}

	/**
	 * 根据body获取页面的keywords
	 * 
	 * @param body
	 * @return
	 */
	public static String getAMetaK(String body) {
		String content = null;
		Elements metas = getDoc(body).select("meta");
		for (Element meta : metas) {
			String name = meta.attr("name");
			if (name.equals("keywords")) {
				content = meta.attr("content");
				return content;
			}
		}
		return "";
	}

	/**
	 * 根据body获取页面的description
	 * 
	 * @param body
	 * @return
	 */
	public static String getAMetaD(String body) {
		Elements metas = getDoc(body).select("meta");
		for (Element meta : metas) {
			String name = meta.attr("name");
			if (name.equals("description")) {
				String content = meta.attr("content");
				return content;
			}
		}
		return "";
	}

	/**
	 * 将list放入UrlBean类中
	 * @param list
	 * @return
	 */
	public static UrlBean getUrlBean(List<String> list) {
		UrlBean urlBean = new UrlBean();
		if (list != null && list.size() > 0) {
			try {
				// 循环获取对象
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) != null) {
						urlBean.setUrl(list.get(i)); // 获取
					} else {
						continue;
					}
				}
				return urlBean;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
			}
		}
		return urlBean;
	}

	/**
	 * 将获取的title、keywords、description、url放入itemBean实体类中
	 * 
	 * @param body
	 * @param url
	 * @return
	 */
	public static ItemBean getItemBean(String body, String url) {
		Document doc = getDoc(body);
		ItemBean itemBean = new ItemBean();
		itemBean.setTitle(doc.title());
		itemBean.setKeywords(getAMetaK(body));
		itemBean.setDescription(getAMetaD(body));
		itemBean.setUrl(url);
		return itemBean;
	}
}

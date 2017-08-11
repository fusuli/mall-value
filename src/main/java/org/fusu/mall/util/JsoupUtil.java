package org.fusu.mall.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.fusu.mall.bean.ItemBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author fusu
 *
 */
public class JsoupUtil {
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

	public static List<String> getALink(String html) {
		List<String> list = new ArrayList<String>();
		Elements links = getDoc(html).select("a");
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

	public static List<String> getLinkedHashSet(List<String> list) {
		LinkedHashSet<String> set = new LinkedHashSet<String>(list);
		ArrayList<String> list2 = new ArrayList<String>(set);
		return list2;
	}

	public static String getAMetaK(String html) {
		String content = null;
		Elements metas = getDoc(html).select("meta");
		for (Element meta : metas) {
			String name = meta.attr("name");
			if (name.equals("keywords")) {
				content = meta.attr("content");
				return content;
			}
		}
		return "";
	}

	public static String getAMetaD(String html) {
		Elements metas = getDoc(html).select("meta");
		for (Element meta : metas) {
			String name = meta.attr("name");
			if (name.equals("description")) {
				String content = meta.attr("content");
				return content;
			}
		}
		return "";
	}

	public static ItemBean getItemBean(String html, String url) {
		Document doc = getDoc(html);
		ItemBean itemBean = new ItemBean();
		itemBean.setTitle(doc.title());
		itemBean.setKeywords(getAMetaK(html));
		itemBean.setDescription(getAMetaD(html));
		itemBean.setUrl(url);
		return itemBean;
	}
}

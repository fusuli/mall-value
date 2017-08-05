package org.fusu.mall.value;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		Document doc = App.parseDocumentFromUrl();
		String title = doc.title();
		String description = doc.text();
		Elements links = doc.select("a");
		Elements metas  = doc.select("meta");
//		for(Element link:links) {
//			String url = link.attr("href");
//			String text = link.text();
//			System.out.println(url+ " : " + text);
//		}
		for(Element meta:metas) {
			String name = meta.attr("name");
			if(name.equals("keywords") || name.equals("description")){
				String content = meta.attr("content");
				System.out.println(name + " : content " +content );
			}
		}
	}

	public static Document parseDocumentFromUrl() {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://shouji.jd.com/").get();
			// data(key,value)是该URL要求的参数
			// userAgent制定用户使用的代理类型
			// cookie带上cookie，如cookie("JSESSIONID","FDE234242342342423432432")
			// 连接超时时间
			// post或者get方法
			// doc = Jsoup.connect("https://shouji.jd.com/")
			// .data("query", "Java")
			// .userAgent("Mozilla")
			// .cookie("auth", "token")
			// .timeout(3000)
			// .post();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
}

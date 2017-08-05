package org.fusu.mall.value;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ListLinks {

     public static Document parseDocumentFromUrl(){
         Document doc = null;
         try {
             doc = Jsoup.connect("url").get();
             //获取标题
             String title = doc.title();
             System.out.println(title);//输出：Google
             //data(key,value)是该URL要求的参数
             //userAgent制定用户使用的代理类型
             //cookie带上cookie，如cookie("JSESSIONID","FDE234242342342423432432")
             //连接超时时间
             //post或者get方法
             doc = Jsoup.connect("http://www.xxxxx.com/")
                       .data("query", "Java")
                       .userAgent("Mozilla")
                       .cookie("auth", "token")
                       .timeout(3000)
                       .post();
              
         } catch (IOException e) {
             e.printStackTrace();
         }
         return doc;
     }
}

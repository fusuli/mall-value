package org.fusu.test.util;

import java.util.List;

import org.fusu.mall.util.JsoupUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;


public class JsoupUtilTest {
	@Test
	public void testGetDoc() {
		Document doc = Jsoup.parse("<html><body></body></html>");
		Assert.assertNotNull(doc);
	}
	
	@Test
	public void testGetTitle() {
		String title = JsoupUtil.getTitle("<html> <meta charset=\"gbk\" />"
				+ "<title>手机_手机通讯_运营商手机_手机配件-京东</title><body></body></html>");
		Assert.assertNotNull(title);
	}
	
	@Test
	public void testGetALink() {
		List<String> alink = JsoupUtil.getALink("<html> <meta charset=\"gbk\" />"
				+ "<title>手机_手机通讯_运营商手机_手机配件-京东</title><body>"
				+ "<div style=\"display:none\">\r\n" + 
				"	<a href=\"//yp.jd.com\">京东优评</a>\r\n" + 
				"	<a href=\"//yp.jd.com/5025c7b5f6a0816c0bf1.html\">卡地亚女士手表</a>\r\n" + 
				"	<a href=\"//yp.jd.com/list/737_13297_13298.html\">燃气灶</a>\r\n" + 
				"	<a href=\"//yp.jd.com/list/670_671_672.html\">笔记本</a>\r\n" + 
				"	<a href=\"//yp.m.jd.com\">优评M版</a>\r\n" + 
				"	<a href=\"//yp.jd.com/list/670_671_2694.html\">平板电脑</a>\r\n" + 
				"	<a href=\"//yp.jd.com/5025dff9c1142b4bb1fb.html\">雷达表</a>\r\n" + 
				"	<a href=\"//yp.jd.com/5025dff9c1142b4bb1fb.html\">雷达表</a>\r\n" + 
				"	<a href=\"//yp.jd.com/list/670_671_1105.html\">游戏本</a>\r\n" + 
				"	<a href=\"//yp.jd.com/131881327efe5d5018a4.html\">范斯板鞋</a>\r\n" + 
				"	<a href=\"//yp.jd.com/13157cc627b1ec55f4a8.html\">短款雪纺衫</a>\r\n" + 
				"	<a href=\"//yp.jd.com/13194ab1d297622a4109.html\">惠氏奶粉三段</a>\r\n" + 
				"	<a href=\"//yp.jd.com/13195b755009677880fa.html\">配方牛奶粉</a>\r\n" + 
				"	<a href=\"//yp.jd.com/737d29565c936879552.html\">美的（Midea）十字对开门风冷（无霜）冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/7370f5ac3d3fbb9fb68.html\">美的（Midea）十字对开门冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/73705bdd46f2e06d34f.html\">DIMCHAE多门变频冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/737aced01a94f6b76a3.html\">惠而浦（whirlpool）多门冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/737673e4be31ad4037c.html\">卡萨帝（Casarte）多门冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/737d8e80a5763411f2e.html\">航天电器双门定频冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/73762c2292d24e50180.html\">倍科（BEKO）风冷（无霜）变频冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/73722327ce065311a36.html\">尊贵（ZUNGUI）对开门直冷冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/73747d82833a4bb262c.html\">卡萨帝（Casarte）多门变频冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/737ab77f6f27d629127.html\">帕琪丝（PATCHES）三门定频冰箱</a>\r\n" + 
				"	<a href=\"//item.jd.com/737be043cb0c7050ba0.html\">德努希（DENUSSI）多门风冷（无霜）冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/7378688bcb647082093.html\">美菱（MeiLing）对开门直冷冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/737f802e3b8fe63e2fd.html\">航天电器直冷冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/7377c96e342bbe86d1d.html\">晶弘（KINGHOME）风冷（无霜）变频冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/737f92aa053a78a8681.html\">小咖（small potato）直冷冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/7372e8c268f60203a61.html\">卡萨帝（Casarte）不锈钢冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/737742e209ffdf99c97.html\">三星（SAMSUNG）直冷变频冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/737a3c05846a6de10b6.html\">新飞（Frestec）三门直冷冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/737234cb35cd338ffe2.html\">统帅（Leader）三门直冷冰箱</a>\r\n" + 
				"	<a href=\"//yp.jd.com/7374c138afafb52c7b8.html\">航天民生（HTminsheng）多门直冷冰箱</a>\r\n" + 
				"</div></body></html>");
		Assert.assertNotNull(alink.size());
	}
}

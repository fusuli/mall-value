package org.fusu.test.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.fusu.mall.dao.UrlDao;
import org.junit.Test;

public class UrlDaoTest {

	//@Test
	public void testAddUrl() {
		UrlDao urlDao = new UrlDao();
		List<String> list = null;
		list.set(0, "https://item.jd.com/11.html");
		urlDao.addUrl(list);
		
	}
	
	@Test
	public void testSelectUrl() {
		UrlDao urlDao = new UrlDao();
		boolean b = urlDao.selectUrl("https://item.jd.com/3458059.html");
		System.out.println(b);
		assertNotNull(b);
	}
	
	//@Test
	public void testUpdateUrlStatus() {
		UrlDao urlDao = new UrlDao();
		urlDao.updateUrlStatus("https://item.jd.com/3458059.html");
		
	}
	
}

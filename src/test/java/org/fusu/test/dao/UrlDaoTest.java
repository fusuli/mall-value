package org.fusu.test.dao;

import static org.junit.Assert.assertNotNull;

import org.fusu.mall.dao.UrlDao;
import org.junit.Test;

public class UrlDaoTest {
	
	@Test
	public void testSelectUrl() {
		UrlDao urlDao = new UrlDao();
		boolean b = urlDao.selectUrl("https://item.jd.com/3458059.html");
		System.out.println(b);
		assertNotNull(b);
	}
}

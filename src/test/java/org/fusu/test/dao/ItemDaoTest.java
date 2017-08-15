package org.fusu.test.dao;

import static org.junit.Assert.assertNotNull;

import org.fusu.mall.dao.ItemDao;
import org.junit.Test;

public class ItemDaoTest {
	@Test
	public void testSelectUrl() {
		ItemDao itemDao = new ItemDao();
		String title = "手机_手机通讯_运营商手机_手机配件-京";
		boolean b = itemDao.selectItem(title);
		System.out.println(b);
		assertNotNull(b);
	}
}

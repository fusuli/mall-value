package org.fusu.test.dao;

import static org.junit.Assert.assertNotNull;

import org.fusu.mall.dao.ItemDao;
import org.junit.Test;

public class ItemDaoTest {
	@Test
	public void testSelectUrl() {
		ItemDao itemDao = new ItemDao();
		String title = "笔记本 电脑整机 电脑、办公【行情 价格 评价 图片】- 京东";
		boolean b = itemDao.selectItem(title);
		System.out.println(b);
		assertNotNull(b);
	}
}

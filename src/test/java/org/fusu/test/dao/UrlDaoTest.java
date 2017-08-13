package org.fusu.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.fusu.mall.bean.UrlBean;
import org.fusu.mall.dao.UrlDao;
import org.fusu.mall.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class UrlDaoTest {

	@SuppressWarnings("null")
	@Test
	public void testAddUrl() {
		UrlBean urlBean = new UrlBean();
		urlBean.setUrl("https://item.jd.com/1.html");
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			session.save(urlBean);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
	}
	
	@Test
	public void testSelectUrl() {
		UrlDao urlDao = new UrlDao();
		boolean b = urlDao.selectUrl("https://item.jd.com/161099.html");
		System.out.println(b);
		assertNotNull(b);
	}
	
}

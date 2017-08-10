package org.fusu.mall.dao;

import org.fusu.mall.bean.ItemBean;
import org.fusu.mall.util.HibernateUtil;
import org.hibernate.Session;

public class ItemDao implements IItemDao {

	@Override
	public void addItem(ItemBean itemBean) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			session.save(itemBean);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
	}
}

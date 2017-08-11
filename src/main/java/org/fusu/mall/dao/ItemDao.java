package org.fusu.mall.dao;

import java.util.Iterator;
import java.util.List;

import org.fusu.mall.bean.ItemBean;
import org.fusu.mall.bean.UrlBean;
import org.fusu.mall.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class ItemDao implements IItemDao {

//	@Override
//	public void addItem(ItemBean itemBean) {
//		// TODO Auto-generated method stub
//		Session session = null;
//		try {
//			session = HibernateUtil.openSession();
//			session.beginTransaction();
//			session.save(itemBean);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			HibernateUtil.close(session);
//		}
//	}
	@Override
	public void addItem(ItemBean itemBean) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			if(selectItem(itemBean.getTitle().trim())) {
				session.save(itemBean);
			}else {
			System.out.println("item已经存在");
			}
//			session.save(itemBean);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
	}
	public boolean selectItem(String title) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			Query query = session.createQuery("from ItemBean where title = ?");
			@SuppressWarnings("unchecked")
			List<UrlBean> urlBean = query.list();
			Iterator<UrlBean> it = urlBean.iterator();
			if (it.hasNext()) {
				if (it.next().equals(null)) {
					return false;
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return false;
	}
}

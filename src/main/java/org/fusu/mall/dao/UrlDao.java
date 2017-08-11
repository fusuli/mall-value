package org.fusu.mall.dao;

import java.util.Iterator;
import java.util.List;

import org.fusu.mall.bean.UrlBean;
import org.fusu.mall.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class UrlDao implements IUrlDao {

	@Override
	public void addUrl(List<String> list) {
		// TODO Auto-generated method stub
		Session session = null;
		if (list != null && list.size() > 0) {
			try {
				session = HibernateUtil.openSession(); // 获取Session
				session.beginTransaction(); // 开启事物
				UrlBean urlBean = new UrlBean(); // 创建对象
				// 循环获取对象
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) != null && selectUrl(list.get(i))) {
//						&& selectUrl(list.get(i))
						urlBean.setUrl(list.get(i)); // 获取
						session.save(urlBean); // 保存对象
						// 批插入的对象立即写入数据库并释放内存
						if (i % 1 == 0) {
							session.flush();
							session.clear();
						}
					} else {
						System.out.println("url已经存在");
						continue;
					}
				}
				session.getTransaction().commit(); // 提交事物
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				session.getTransaction().rollback(); // 出错将回滚事物
			} finally {
				HibernateUtil.close(session);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UrlBean> getAllUrl() {
		// TODO Auto-generated method stub
		Session session = null;
		List<UrlBean> urlList = null;
		try {
			session = HibernateUtil.openSession();
			// Query 查询语句，select * 可以省略，也可以大小写不论，
			// 但是，from 后面的就一定要大小写区分，因为它后面接的是 实体类
			Query query = session.createQuery("from UrlBean");

			// 返回一个List集合，hibernate的优点就是，不用再向集合中add这样添加元素了，Query已经自动提交了
			urlList = query.list();
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.beginTransaction().rollback();
		} finally {
			HibernateUtil.close(session);
		}
		return urlList;
	}

	public void testQuery() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();

			// Query 查询语句，select * 可以省略，也可以大小写不论，
			// 但是，from 后面的就一定要大小写区分，因为它后面接的是 实体类
			Query query = session.createQuery("from UrlBean");

			// 分页
			// query.setFirstResult(0);//从第零条记录开始
			// query.setMaxResults(200);//每页2条记录

			// 返回一个List集合，hibernate的优点就是，不用再向集合中add这样添加元素了，Query已经自动提交了
			@SuppressWarnings("unchecked")
			List<UrlBean> urlList = query.list();
			for (Iterator<UrlBean> it = urlList.iterator(); it.hasNext();) {
				UrlBean urlBean = (UrlBean) it.next();
				System.out.println(urlBean.getUrlid());
				System.out.println(urlBean.getUrl());
			}
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.beginTransaction().rollback();
		} finally {
			HibernateUtil.close(session);
		}
	}

	@Override
	public boolean selectUrl(String url) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			Query query = session.createQuery("from UrlBean where url = ?");
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

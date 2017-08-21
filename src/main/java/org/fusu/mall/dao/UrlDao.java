package org.fusu.mall.dao;

import java.util.List;

import org.fusu.mall.bean.UrlBean;
import org.fusu.mall.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import org.apache.commons.lang3.StringUtils;

public class UrlDao implements IUrlDao {

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
					String nowUrl = list.get(i).trim();
					boolean isSave = selectUrl(nowUrl);
					if (!StringUtils.isEmpty(nowUrl) && isSave == false) {
						// && selectUrl(list.get(i))
						urlBean.setUrl(StringUtils.trim(nowUrl)); // 获取
						urlBean.setStatus(0);
						
						session.save(urlBean); // 保存对象
						System.out.println("URL added successfully" + i);
						// 批插入的对象立即写入数据库并释放内存
						if (i % 1 == 0) {
							session.flush();
							session.clear();
						}
					} else {
						System.err.println("URL already exists!!!");
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
	public List<UrlBean> getAllUrl() {
		// TODO Auto-generated method stub
		Session session = null;
		List<UrlBean> urlList = null;
		try {
			session = HibernateUtil.openSession();
			// Query 查询语句，select * 可以省略，也可以大小写不论，
			// 但是，from 后面的就一定要大小写区分，因为它后面接的是 实体类
			Query query = session.createQuery("from UrlBean where status = 0");
			query.setFirstResult(0);
			query.setMaxResults(100);
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

	public boolean selectUrl(String url) {
		url = StringUtils.trim(url);
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			Query query = session.createQuery("from UrlBean where url = ?");
			query.setString(0, url);
			@SuppressWarnings("unchecked")
			List<UrlBean> urlBean = query.list();
			return urlBean.size() > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return true;
	}

	public void updateUrlStatus(String url) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			Query query = session.createQuery("update UrlBean u set u.status = '100' where url = ?");
			query.setParameter(0, url);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
	}

}

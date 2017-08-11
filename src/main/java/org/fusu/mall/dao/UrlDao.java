package org.fusu.mall.dao;

import java.util.List;

import org.fusu.mall.bean.UrlBean;
import org.fusu.mall.util.HibernateUtil;
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
						System.out.println(list.get(i));
						urlBean.setUrl(list.get(i)); // 获取
						session.save(urlBean); // 保存对象
						// 批插入的对象立即写入数据库并释放内存
						if (i % 1 == 0) {
							session.flush();
							session.clear();
						}
					} else {
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

	@Override
	public boolean selectUrl(String url) {
		// TODO Auto-generated method stub
		Session session = null;
		String url2 = null;
		try {
			session = HibernateUtil.openSession();
			url2 = (String) session.createQuery("from mall_url where url = ?").getQueryString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		if (url != url2) {
			return true;
		}
		return false;
	}

}

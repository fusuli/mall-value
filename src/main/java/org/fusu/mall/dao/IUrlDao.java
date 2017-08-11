package org.fusu.mall.dao;

import java.util.List;

import org.fusu.mall.bean.UrlBean;

public interface IUrlDao {
	public void addUrl(List<String> list);
	
	public List<UrlBean> getAllUrl();
	
	public void testQuery();
	
	public boolean selectUrl(String url);
}

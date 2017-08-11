package org.fusu.mall.dao;

import java.util.List;

public interface IUrlDao {
	public void addUrl(List<String> list);
	public boolean selectUrl(String url);
}

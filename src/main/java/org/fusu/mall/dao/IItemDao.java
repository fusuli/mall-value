package org.fusu.mall.dao;

import org.fusu.mall.bean.ItemBean;

public  interface IItemDao {
	public void addItem(ItemBean itemBean);

	public boolean selectItem(String url);
}

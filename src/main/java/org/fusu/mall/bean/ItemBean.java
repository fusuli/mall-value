package org.fusu.mall.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mall_html")
public class ItemBean {
	@Id
	@GeneratedValue
	@Column(name = "itemid")
	private int itemid;

	@Column(name = "title")
	private String title;

	@Column(name = "keywords")
	private String keywords;

	@Column(name = "description")
	private String description;

	@Column(name = "url")
	private String url;

	public ItemBean() {
	}

	public ItemBean(String title, String description, String keywords, String url) {
		this.title = title;
		this.description = description;
		this.keywords = keywords;
		this.url = url;
	}

	public ItemBean(int itemid, String title, String description, String keywords, String url) {
		this.itemid = itemid;
		this.title = title;
		this.description = description;
		this.keywords = keywords;
		this.url = url;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}

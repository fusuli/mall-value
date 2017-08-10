package org.fusu.mall.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mall_url")
public class UrlBean {

	@Id
	@GeneratedValue
	@Column(name = "urlid")
	private int urlid;
	@Column(name = "url")
	private String url;

	public UrlBean() {
	}

	public UrlBean(String url) {
		this.url = url;
	}

	public UrlBean(int urlid, String url) {
		this.urlid = urlid;
		this.url = url;
	}

	public int getUrlid() {
		return urlid;
	}

	public void setUrlid(int urlid) {
		this.urlid = urlid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

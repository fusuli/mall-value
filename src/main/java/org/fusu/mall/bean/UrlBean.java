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

	@Column(name = "status")
	private int status;

	@Column(name = "update_time")
	private int update_time;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(int update_time) {
		this.update_time = update_time;
	}
	
}

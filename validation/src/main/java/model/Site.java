package model;

import org.hibernate.validator.constraints.URL;

public class Site {

	@URL
	private String url;

	public Site(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}

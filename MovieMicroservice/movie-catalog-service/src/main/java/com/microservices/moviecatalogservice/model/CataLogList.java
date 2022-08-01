package com.microservices.moviecatalogservice.model;

import java.util.List;

public class CataLogList {
	
	public CataLogList() {
		super();
	}

	private List<CatalogItem> catalogList;

	public List<CatalogItem> getCatalogList() {
		return catalogList;
	}

	public void setCatalogList(List<CatalogItem> catalogList) {
		this.catalogList = catalogList;
	}
}

package com.UmmahsKitchen.MenuService.VO;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
	
@Component
public class MenuItemsVO {
	
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("price")
	private String price;
	
	@JsonProperty("createdBy")
	private String createdBy;
	
	@JsonProperty("createTS")
	private String createTs;
	
	@JsonProperty("udateTs")
	private String updateTs;
	
	@JsonProperty("category")
	private CATEGORY category;
	

	public CATEGORY getCategory() {
		return category;
	}
	public void setCategory(CATEGORY category) {
		this.category = category;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreateTs() {
		return createTs;
	}
	public void setCreateTs(String createTs) {
		this.createTs = createTs;
	}
	public String getUpdateTs() {
		return updateTs;
	}
	public void setUpdateTs(String updateTs) {
		this.updateTs = updateTs;
	}
	
	public enum CATEGORY {
		SPECIALS,STARTERS,BREADS,RICE,GRAVY,MISC,DESSERTS
	}
	
}


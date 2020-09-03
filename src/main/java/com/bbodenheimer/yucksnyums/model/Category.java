package com.bbodenheimer.yucksnyums.model;

public class Category {
	
	int id;
	String description;
	String icon;
	
	public Category(int id, String description, String icon) {
		this.id = id;
		this.description = description;
		this.icon = icon;
	}

	public Category(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", description=" + description + ", icon=" + icon
				+ "]";
	}
}

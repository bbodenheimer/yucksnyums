package com.bbodenheimer.yucksnyums.model;

public class Category {
	
	int id;
	String description;
	
	public Category(int id, String description) {
		this.id = id;
		this.description = description;
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", description=" + description
				+ "]";
	}
}

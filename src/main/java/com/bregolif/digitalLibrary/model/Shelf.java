package com.bregolif.digitalLibrary.model;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Shelf {
	@Id
	int shelfId;
	String category;
	double width;
	@ManyToOne
	Library library;
	
	public int getShelfId() {
		return shelfId;
	}
	
	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public Library getLibrary() {
		return library;
	}
	
	public void setLibrary(Library library) {
		this.library = library;
	}
	
	@Override
	public String toString() {
		return "Shelf [shelfId=" + shelfId + ", category=" + category + ", width=" + width + ", library=" + library
				+ "]";
	}
	
}

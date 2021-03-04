package com.bregolif.digitalLibrary.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Every shelf will have books, but them books' width must not
 * surpass the shelf width
 * @author franco
 *
 */
@Entity
public class Shelf {
	@Id
	Integer shelfId;
	String category;
	double width;
	@ManyToOne
	Library library;
	@OneToMany(mappedBy="shelf")
	List<Book> book;
	
	public Shelf(){}
	
	public Shelf(Integer shelfId, double width, Library library) {
		super();
		this.shelfId = shelfId;
		this.category = "";
		this.width = width;
		this.library = library;
		this.book = new ArrayList<>();
	}

	public Integer getShelfId() {
		return shelfId;
	}
	
	public void setShelfId(Integer shelfId) {
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

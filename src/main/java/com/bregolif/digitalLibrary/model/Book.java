package com.bregolif.digitalLibrary.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	String ISBN;
	String name;
	String category;
	int width;
	@ManyToOne
	Library library;
	@ManyToOne
	Shelf shelf;
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}  
	
	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	@Override
	public String toString() {
		return "[ISBN=" + ISBN + ", name=" + name + ", category=" + category + ", width=" + width + ", library="
				+ library.name + ", shelf=" + shelf.getShelfId() + "]";
	}

	

}

package com.bregolif.digitalLibrary.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Each library will have a specific number of shelfs, and variable
 * number of books
 * @author franco
 *
 */
@Entity
public class Library {
	@Id
	String name;
	int shelfNumber;
	int shelfWidth;
	@OneToMany(mappedBy="library")
	List<Book> book;
	@OneToMany(mappedBy="library")
	List<Shelf> shelf;
	
	public Library() {}
	
	public Library(String name, int shelfNumber, int shelfWidth) {
		super();
		this.name = name;
		this.shelfNumber = shelfNumber;
		this.shelfWidth = shelfWidth;
		this.book = new ArrayList<>();
		this.shelf = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShelfNumber() {
		return shelfNumber;
	}

	public void setShelfNumber(int shelfNumber) {
		this.shelfNumber = shelfNumber;
	}

	public int getShelfWidth() {
		return shelfWidth;
	}

	public void setShelfWidth(int shelfWidth) {
		this.shelfWidth = shelfWidth;
	}

	public List<Book> getBook() {
		return book;
	}
	
	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	public List<Shelf> getShelf() {
		return shelf;
	}
	
	public void setShelf(List<Shelf> shelf) {
		this.shelf = shelf;
	}

	@Override
	public String toString() {
		return "Library [name=" + name + ", shelfNumber=" + shelfNumber + ", book=" + book + ", shelf=" + shelf + "]";
	}
	
}

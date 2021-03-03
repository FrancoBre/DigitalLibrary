package com.bregolif.digitalLibrary.model;

import java.util.List;

import javax.persistence.Column;
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
	int libraryId;
	@Column
	String name;
	@OneToMany(mappedBy="library")
	List<Book> book;
	@OneToMany(mappedBy="library")
	List<Shelf> shelf;
	
	public Integer getLibraryId() {
		return libraryId;
	}
	
	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Library [libraryId=" + libraryId + ", book=" + book + ", shelf=" + shelf + "]";
	}
	
}

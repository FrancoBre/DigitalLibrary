package com.bregolif.digitalLibrary.service;

import java.util.List;
import java.util.Optional;

import com.bregolif.digitalLibrary.model.Book;
import com.bregolif.digitalLibrary.model.Library;
import com.bregolif.digitalLibrary.model.Shelf;

public interface LibraryServiceInterface {

		public void save(Library library);
		public boolean save(Book book);
		public Shelf getShelf(String category);
		public void save(String name, Integer shelfNumber, Integer shelfWidth);
		public void label(Integer shelfId, String category);
		public boolean shelfExists(Integer shelfId);
		public void remove(String isbn);
		public Optional<Book> get(String ISBN);
		public List<Book> getAll();
}

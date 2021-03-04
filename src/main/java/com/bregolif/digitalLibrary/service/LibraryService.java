package com.bregolif.digitalLibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bregolif.digitalLibrary.model.Book;
import com.bregolif.digitalLibrary.model.Library;
import com.bregolif.digitalLibrary.repository.BookRepo;
import com.bregolif.digitalLibrary.repository.LibraryRepo;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepo lRepo;
	
	@Autowired
	private BookRepo bRepo;
	
	public void save(Library library) { lRepo.save(library); }
	
	public void save(Book book) { bRepo.save(book); }
	
	public void save(String name, int shelfNumber, int shelfWidth) {
		Library library = new Library(name, shelfNumber, shelfWidth);
		lRepo.save(library);
	}
	
	public void remove(String isbn) { bRepo.deleteById(isbn); }
	
	public Optional<Book> get(String ISBN) { return bRepo.findById(ISBN); }
	
	public List<Book> getAll() { return bRepo.findAll(); }
}

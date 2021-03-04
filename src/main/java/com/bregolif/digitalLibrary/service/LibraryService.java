package com.bregolif.digitalLibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bregolif.digitalLibrary.model.Book;
import com.bregolif.digitalLibrary.model.Library;
import com.bregolif.digitalLibrary.model.Shelf;
import com.bregolif.digitalLibrary.repository.BookRepo;
import com.bregolif.digitalLibrary.repository.LibraryRepo;
import com.bregolif.digitalLibrary.repository.ShelfRepo;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepo lRepo;
	
	@Autowired
	private BookRepo bRepo;
	
	@Autowired
	private ShelfRepo sRepo;
	
	public void save(Library library) { lRepo.save(library); }
	
	public void save(Book book) { bRepo.save(book); }
	
	/**
	 * This method creates a library and with it, its shelfs
	 * @param name, shelfNumber, shelfWidth are the three parameters for
	 * library creation, while the other parameters are initialized as
	 * ArrayList for later book additions
	 * 
	 */
	public void save(String name, int shelfNumber, int shelfWidth) {
		Library library = new Library(name, shelfNumber, shelfWidth);
		lRepo.save(library);
		
		for (int i = 0; i < shelfNumber; i++) {
			Shelf shelf = new Shelf(i, shelfWidth, library);
			sRepo.save(shelf);
		}
	}
	
	/**
	 * Labels a shelf with a category
	 * 
	 */
	public void label(int shelfId, String category) {
		
	}
	
	public void remove(String isbn) { bRepo.deleteById(isbn); }
	
	public Optional<Book> get(String ISBN) { return bRepo.findById(ISBN); }
	
	public List<Book> getAll() { return bRepo.findAll(); }
}

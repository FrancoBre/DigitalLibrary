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
public class LibraryService implements LibraryServiceInterface {
	
	@Autowired
	private LibraryRepo lRepo;
	
	@Autowired
	private BookRepo bRepo;
	
	@Autowired
	private ShelfRepo sRepo;
	
	public void save(Library library) { lRepo.save(library); }
	
	/**
	 * @return if there is a book labeled with the @param book's category,
	 * the book is added to a corresponding shelf and the method returns 
	 * true. If there is no shelf labeled with the book's category or the, 
	 * book doesn't fit in the shelf, the method returns false.
	 * 
	 */
	public boolean save(Book book) { 
		Shelf shelf = getShelf(book.getCategory());
		
		if(shelf == null || fitsInShelf(shelf, book)) 
			return false;
		else {
			book.setLibrary(shelf.getLibrary());	// Set book's shelf 
			book.setShelf(shelf);			 		// and library
			bRepo.save(book);
			shelf.getBook().add(book);				// Update shelf's
			sRepo.save(shelf);		   				// book list
			return true;
		}
	}

	/**
	 * @return returns a shelf for a specific @param category, if it 
	 * exists. If it doesn't, it will return null.
	 * 
	 */
	public Shelf getShelf(String category) {
		Shelf ret = null;
		
		for(Shelf shelf : sRepo.findAll()) 
			if(shelf.getCategory().equals(category))
				ret = shelf;
		
		return ret;
	}
	
	/**
	 * This method creates a library and with it, its shelfs
	 * @param name, shelfNumber, shelfWidth are the three parameters for
	 * library creation, while the other parameters are initialized as
	 * ArrayList for later book additions
	 * 
	 */
	public void save(String name, Integer shelfNumber, Integer shelfWidth) {
		Library library = new Library(name, shelfNumber, shelfWidth);
		lRepo.save(library);
		
		for (Integer i = 1; i < shelfNumber+1; i++) {
			Shelf shelf = new Shelf(i, shelfWidth, library);
			sRepo.save(shelf);
		}
	}
	
	/**
	 * Labels a shelf with a category
	 * 
	 */
	public void label(Integer shelfId, String category) {
		Shelf shelf = sRepo.findById(shelfId).orElse(null);
		shelf.setCategory(category);
		sRepo.save(shelf);
	}
	
	/**
	 * Checks if a shelf exists based on its id
	 * 
	 */
	public boolean shelfExists(Integer shelfId) {
		return sRepo.existsById(shelfId);
	}
	
	/**
	 * Indicates if the book would fit in the shelf
	 * 
	 */
	public boolean fitsInShelf(Shelf shelf, Book book) {
		return freeSpace(shelf) <= book.getWidth();
	}
	
	/**
	 * @return return how many free space does the @param shelf has
	 */
	public double freeSpace(Shelf shelf) {
		double ret = shelf.getWidth();
		for(Book book : shelf.getBook())
			ret = ret - book.getWidth();
		return ret;
	}
	
	public List<Shelf> getAllShelfs() { return sRepo.findAll(); }
	
	public void remove(String isbn) { bRepo.deleteById(isbn); }
	
	public Optional<Book> get(String ISBN) { return bRepo.findById(ISBN); }
	
	public List<Book> getAll() { return bRepo.findAll(); }

}

package com.bregolif.digitalLibrary.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bregolif.digitalLibrary.dao.LibraryRepo;
import com.bregolif.digitalLibrary.model.Book;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepo repo;
	
	public void save(Book book) { repo.save(book); }
	
	public Optional<Book> get(String ISBN) { return repo.findById(ISBN); }
}

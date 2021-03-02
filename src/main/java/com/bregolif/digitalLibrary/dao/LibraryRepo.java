package com.bregolif.digitalLibrary.dao;

import org.springframework.data.repository.CrudRepository;

import com.bregolif.digitalLibrary.model.Book;

public interface LibraryRepo extends CrudRepository<Book, String> {

}

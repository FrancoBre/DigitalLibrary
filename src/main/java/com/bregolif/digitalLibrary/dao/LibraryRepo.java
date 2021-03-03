package com.bregolif.digitalLibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bregolif.digitalLibrary.model.Book;

@Repository
public interface LibraryRepo extends JpaRepository<Book, String> { }

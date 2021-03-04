package com.bregolif.digitalLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bregolif.digitalLibrary.model.Book;

/**
 * This class manages all the CRUD operations for books
 * @author franco
 *
 */
@Repository
public interface BookRepo extends JpaRepository<Book, String>  { }

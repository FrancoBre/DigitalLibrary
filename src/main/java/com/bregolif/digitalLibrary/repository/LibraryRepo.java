package com.bregolif.digitalLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bregolif.digitalLibrary.model.Library;

/**
 * This class manages all the CRUD operations for libraries
 * @author franco
 *
 */
@Repository
public interface LibraryRepo extends JpaRepository<Library, Integer> { }

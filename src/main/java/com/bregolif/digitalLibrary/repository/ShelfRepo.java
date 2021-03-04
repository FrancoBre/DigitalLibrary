package com.bregolif.digitalLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bregolif.digitalLibrary.model.Shelf;

public interface ShelfRepo extends JpaRepository<Shelf, Integer> {}

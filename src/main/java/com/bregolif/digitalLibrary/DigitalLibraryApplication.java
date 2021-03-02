package com.bregolif.digitalLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is a demo application for Spring Boot. This program implements
 * a digital library, where it is possible to create a library with its
 * shelfs and books, add books to a database and so on. Any feedback is
 * welcome :)
 * Technologies used in this program are: Spring Boot, jdbc, H2 and jsp
 * 
 * @author Franco Bregoli, github.com/FrancoBre 
 *
 */
@SpringBootApplication
public class DigitalLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalLibraryApplication.class, args);
	}

}

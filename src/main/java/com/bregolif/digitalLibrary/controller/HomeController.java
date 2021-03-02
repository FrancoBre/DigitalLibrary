package com.bregolif.digitalLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bregolif.digitalLibrary.dao.LibraryRepo;
import com.bregolif.digitalLibrary.model.Book;

@Controller
public class HomeController {
	
	@Autowired
	LibraryRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/addBook")
	public ModelAndView addBook(Book book) {
		ModelAndView ret = new ModelAndView("home");
		
		repo.save(book);
		ret.addObject("result", "Book added");
		return ret;
	}
}

package com.bregolif.digitalLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bregolif.digitalLibrary.model.Book;
import com.bregolif.digitalLibrary.service.LibraryService;

@Controller
public class HomeController {
	
	@Autowired
	LibraryService service;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/addBook")
	public ModelAndView addBook(Book book) {
		ModelAndView ret = new ModelAndView("home");
		
		service.save(book);
		ret.addObject("result", "Book added");
		return ret;
	}
	
	@RequestMapping("/getBook")
	public ModelAndView getBook(@RequestParam String ISBN) {
		ModelAndView ret = new ModelAndView("fetch");
		ret.addObject("book", (service.get(ISBN).isEmpty())?"":service.get(ISBN));
		return ret;
	}
}

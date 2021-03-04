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
	public String main() {
		return "main";
	}
	
	@RequestMapping("/addLibrary")
	public String addLibrary(@RequestParam String name, @RequestParam("shelfNumber") int number,
			@RequestParam("shelfWidth") int width) {
		service.save(name, number, width);
		return "home";
	}
	
	@RequestMapping("/addBook")
	public ModelAndView addBook(Book book) {
		ModelAndView ret = new ModelAndView("addBook");
		service.save(book);
		ret.addObject("result", (book==null)?"":"Book added");
		return ret;
	}
	
	@RequestMapping("/removeBook")
	public ModelAndView removeBook(String isbn) {
		ModelAndView ret = new ModelAndView("addBook");
		service.remove(isbn);
		ret.addObject("result", "Book removed");
		return ret;
	}
	
	@RequestMapping("/getBook")
	public ModelAndView getBook(@RequestParam String ISBN) {
		ModelAndView ret = new ModelAndView("fetchBook");
		ret.addObject("book", (service.get(ISBN).isEmpty())?"":service.get(ISBN));
		return ret;
	}
	
	@RequestMapping("/getAllBooks")
	public ModelAndView getAllBooks() {
		ModelAndView ret = new ModelAndView("fetchAllBooks");
		ret.addObject("books", (service.getAll()));
		return ret;
	}
	
}

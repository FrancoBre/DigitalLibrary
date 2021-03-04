package com.bregolif.digitalLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bregolif.digitalLibrary.model.Book;
import com.bregolif.digitalLibrary.service.LibraryService;

@Controller
public class LibraryController {
	
	@Autowired
	LibraryService service;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/addLibrary")
	public String addLibrary(@RequestParam String name, 
			@RequestParam("shelfNumber") int number,
			@RequestParam("shelfWidth") int width) {
		service.save(name, number, width);
		return "home";
	}
	
	@RequestMapping("/addBook")
	public ModelAndView addBook(Book book) {
		ModelAndView ret = new ModelAndView("addBook");
		ret.addObject("result", (service.save(book))?
				"Book added":"There is not a shelf for the book's category"
						+ ", or that shelf is full");
		return ret;
	}
	
	@RequestMapping("/removeBook")
	public ModelAndView removeBook(@RequestParam String ISBN) {
		ModelAndView ret = new ModelAndView("addBook");
		service.remove(ISBN);
		ret.addObject("result", "Book removed");
		return ret;
	}
	
	@RequestMapping("/getBook")
	public ModelAndView getBook(@RequestParam String ISBN) {
		ModelAndView ret = new ModelAndView("fetchBook");
		ret.addObject("book", (service.get(ISBN).isEmpty())?"":
			service.get(ISBN));
		return ret;
	}
	
	@RequestMapping("/getAllBooks")
	public ModelAndView getAllBooks() {
		ModelAndView ret = new ModelAndView("fetchAllBooks");
		ret.addObject("books", (service.getAll()));
		return ret;
	}
	
	@RequestMapping("/labelShelf")
	public ModelAndView labelShelf(@RequestParam("id") Integer shelfId, 
			@RequestParam String category) {
		ModelAndView ret = new ModelAndView("labelShelf");
		service.label(shelfId, category);
		ret.addObject("result", (service.shelfExists(shelfId)?
				"Shelf labeled succesfully":"Shelf not found"));
		return ret;
	}
	
	@RequestMapping("/getAllShelfs")
	public ModelAndView getAllShelfs() {
		ModelAndView ret = new ModelAndView("fetchAllShelfs");
		ret.addObject("shelfs", (service.getAllShelfs()));
		return ret;
	}
	
}

package com.bregolif.digitalLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bregolif.digitalLibrary.model.Book;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

}

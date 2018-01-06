package com.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.repos.AuthorRepo;

@Controller
public class AuthorController {
	private AuthorRepo authorRepo;

	public AuthorController(AuthorRepo authorRepo) {
		this.authorRepo = authorRepo;
	}
	@RequestMapping("/authors")
	public String getAuthors(Model model){
		model.addAttribute("authors",authorRepo.findAll() );
		return "authors";
	}
}

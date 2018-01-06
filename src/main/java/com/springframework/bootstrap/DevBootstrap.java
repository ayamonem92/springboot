package com.springframework.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springframework.model.Author;
import com.springframework.model.Book;
import com.springframework.repos.AuthorRepo;
import com.springframework.repos.BookRepo;
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private AuthorRepo authorRepo;
	private BookRepo bookRepo;
	
	public DevBootstrap(AuthorRepo authorRepo, BookRepo bookRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}
	private void initData(){
		Author auhtor1 = new Author("Aya","Monem");
		Book book1 = new Book(12133,"JavaEE with spring", "Aya Monem");
		auhtor1.getBooks().add(book1);
		book1.getAuthors().add(auhtor1);
		authorRepo.save(auhtor1);
		bookRepo.save(book1);
		
		Author auhtor2 = new Author("Aya2","Monem2");
		Book book2 = new Book(3424,"JavaEE with spring2", "Aya Monem2");
		auhtor2.getBooks().add(book2);
		book2.getAuthors().add(auhtor2);
		
		authorRepo.save(auhtor2);
		bookRepo.save(book2);
	}
}

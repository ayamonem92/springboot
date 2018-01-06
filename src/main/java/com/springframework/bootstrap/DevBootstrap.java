package com.springframework.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springframework.model.Author;
import com.springframework.model.Book;
import com.springframework.model.Publisher;
import com.springframework.repos.AuthorRepo;
import com.springframework.repos.BookRepo;
import com.springframework.repos.PublisherRepo;
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private AuthorRepo authorRepo;
	private BookRepo bookRepo;
	private PublisherRepo publisherRepo;
	public DevBootstrap(AuthorRepo authorRepo, BookRepo bookRepo,PublisherRepo publisherRepo ) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo=publisherRepo;
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}
	private void initData(){
		Author auhtor1 = new Author("Aya","Monem");
		Publisher publisher1 = new Publisher("Aya Monem","Cairo");
		Book book1 = new Book(12133,"JavaEE with spring", publisher1);
		
		auhtor1.getBooks().add(book1);
		book1.getAuthors().add(auhtor1);
		authorRepo.save(auhtor1);
		publisherRepo.save(publisher1);
		bookRepo.save(book1);
		
		Author auhtor2 = new Author("Aya2","Monem2");
		Publisher publisher2 = new Publisher("Aya Monem2","Giza");
		Book book2 = new Book(3424,"JavaEE with spring2",publisher2);
		auhtor2.getBooks().add(book2);
		book2.getAuthors().add(auhtor2);
		
		authorRepo.save(auhtor2);
		publisherRepo.save(publisher2);
		bookRepo.save(book2);
	}
}

package com.springframework.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int isbn;
	private String title;
	private String publisher;
	@ManyToMany
	@JoinTable(name = "author_book",joinColumns=@JoinColumn(name="book_id"),inverseJoinColumns=@JoinColumn(name="author_id"))
	Set<Author> authors = new HashSet<Author> (); 
	public int getIsbn() {
		return isbn;
	}
	public Book() {
	
	}
	public Book(int isbn, String title, String publisher) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
	}
	public Book(int isbn, String title, String publisher,Set<Author> authors) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.authors = authors;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", publisher=" + publisher + ", authors="
				+ authors + "]";
	}

}

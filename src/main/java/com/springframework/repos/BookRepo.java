package com.springframework.repos;

import org.springframework.data.repository.CrudRepository;

import com.springframework.model.Book;

public interface BookRepo extends CrudRepository<Book, Long>  {

}

package com.springframework.repos;

import org.springframework.data.repository.CrudRepository;

import com.springframework.model.Author;

public interface AuthorRepo extends CrudRepository<Author, Long> {

}

package com.philips.training.service;

import java.util.List;

import com.philips.training.domain.Book;

public interface BookService {

	Book findById(int id);

	List<Book> findAll();

	void deleteById(int id);

	List<Book> findByGenreLike(String genre);

	List<Book> findByName(String name);

	List<Book> findByNameLike(String name);

	List<Book> findByPublisherName(String name);

	int addNewBook(int id, Book toBeAdded);

}
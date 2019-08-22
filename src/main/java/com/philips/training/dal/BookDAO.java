package com.philips.training.dal;

import java.util.List;

import com.philips.training.domain.Book;

public interface BookDAO {

	Book save(int publisher_id, Book b);

	Book findById(int id);

	List<Book> findAll();

	void deleteById(int id);

	List<Book> findByGenreLike(String genre);

	List<Book> findByName(String name);

	List<Book> findByNameLike(String name);

	List<Book> findByPublisherName(String name);

}
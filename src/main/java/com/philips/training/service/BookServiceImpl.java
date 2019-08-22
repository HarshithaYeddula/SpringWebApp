package com.philips.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.training.dal.BookDAO;
import com.philips.training.domain.Book;
import com.philips.training.domain.Publisher;

@Service
public class BookServiceImpl implements BookService  {
	BookDAO b;
	

	@Autowired
	public void setB(BookDAO b) {
		this.b = b;
	}

	@Override
	public int addNewBook(int id,Book toBeAdded) {		
			Book saved = b.save(id, toBeAdded);
			return saved.getId();			
		
	}

	@Override
	public Book findById(int id) {
		return b.findById(id);
	}

	@Override
	public List<Book> findAll() {
		return b.findAll();
	}

	@Override
	public void deleteById(int id) {
		b.deleteById(id);
	}

	@Override
	public List<Book> findByGenreLike(String genre) {
		return b.findByGenreLike(genre);
	}

	@Override
	public List<Book> findByName(String name) {
		return b.findByName(name);
	}

	@Override
	public List<Book> findByNameLike(String name) {
		return b.findByNameLike(name);
	}

	@Override
	public List<Book> findByPublisherName(String name) {
		return b.findByPublisherName(name);
	}
	

	

}

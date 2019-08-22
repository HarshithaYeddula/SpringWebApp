package com.philips.training.dal;

import java.util.List;

import com.philips.training.domain.Book;
import com.philips.training.domain.Publisher;

public interface PublisherDAO {

	Publisher save(Publisher p);

	Publisher findById(int id);

	List<Publisher> findAll();

	void deleteById(int id);


}
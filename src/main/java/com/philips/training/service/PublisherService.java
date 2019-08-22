package com.philips.training.service;

import java.util.List;

import com.philips.training.domain.Publisher;

public interface PublisherService {

	Publisher findById(int id);

	List<Publisher> findAll();

	void deleteById(int id);

	int addNewPublisher(Publisher toBeAdded);

}
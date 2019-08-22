package com.philips.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.philips.training.dal.PublisherDAO;
import com.philips.training.domain.Publisher;
@Service
public class PublisherServiceImpl implements PublisherService {
	
	PublisherDAO p;
    @Autowired
	public void setP(PublisherDAO p) {
		this.p = p;
	}
	
	@Override
	public int addNewPublisher(Publisher toBeAdded) {		
			Publisher saved = p.save(toBeAdded);
			return saved.getId();			
		
	}

	@Override
	public Publisher findById(int id) {
		return p.findById(id);
	}

	@Override
	public List<Publisher> findAll() {
		return p.findAll();
	}

	@Override
	public void deleteById(int id) {
		p.deleteById(id);
	}
	
	

}

package com.philips.training.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.training.domain.Book;
import com.philips.training.domain.Publisher;
import com.philips.training.service.BookService;
import com.philips.training.service.PublisherService;
@RestController
public class ControllerRest {
	
	BookService bs;
	PublisherService ps;
	
	@Autowired
	public void setBs(BookService bs) {
		this.bs = bs;
	}
	
	@Autowired
	public void setPs(PublisherService ps) {
		this.ps = ps;
	}
	
	@RequestMapping(value="/api/publishers", method = RequestMethod.GET)
	public List<Publisher> getAllPublishers(){
		return ps.findAll();
	}
	
	@RequestMapping(value="/api/publishers", method = RequestMethod.POST)
	public ResponseEntity<Publisher> addingProduct(@RequestBody Publisher tobesaved) {
		
		try {
		int id = ps.addNewPublisher(tobesaved);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/api/publisher/"+id));
		
		return new ResponseEntity<>(headers,HttpStatus.CREATED);
		}catch(IllegalArgumentException e) { // when business logic fails, bad parameters are given by the user
			return new ResponseEntity<Publisher>(HttpStatus.BAD_REQUEST);
		}
				
	}
		
	@RequestMapping(value="/api/publishers/{id}", method = RequestMethod.GET)
	public ResponseEntity<Publisher> getOne(@PathVariable("id")int id){
		Publisher p = ps.findById(id);
		if(p!=null) 
			return new ResponseEntity<Publisher>(p,HttpStatus.OK);		
		else
		    return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/api/books", method = RequestMethod.GET)
	public List<Book> getAllBooks(){
		return bs.findAll();
	}
	
	@RequestMapping(value="/api/books", method = RequestMethod.POST)
	public ResponseEntity<Book> addingBook(@RequestBody Book tobesaved) {
		
		try {
	    
	    int id = tobesaved.getPublisher().getId();
		int id_ = bs.addNewBook(id, tobesaved);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/api/books/"+id_));
		
		return new ResponseEntity<>(headers,HttpStatus.CREATED);
		}catch(IllegalArgumentException e) { // when business logic fails, bad parameters are given by the user
			return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
		}
				
	}
	
	@RequestMapping(value="/api/book/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable("id")int id){
		Book b = bs.findById(id);
		if(b!=null) 
			return new ResponseEntity<Book>(b,HttpStatus.OK);		
		else
		    return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/api/book/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteOne(@PathVariable("id")int id){
		Book b = bs.findById(id);
		if(b!=null) {
			bs.deleteById(id);
			return new ResponseEntity<Book>(b,HttpStatus.OK);}		
		else
		    return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	
	
	
	

}

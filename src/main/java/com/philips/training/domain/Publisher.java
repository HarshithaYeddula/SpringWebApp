package com.philips.training.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	private String name;
	private String city;
	
	@OneToMany(mappedBy="publisher",fetch=FetchType.EAGER)	
	List<Book> books = new ArrayList<>();
	
	public Publisher() {
		
	}

	public Publisher(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonIgnore
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", city=" + city + ", books=" + books + "]";
	}
	
	
	
}

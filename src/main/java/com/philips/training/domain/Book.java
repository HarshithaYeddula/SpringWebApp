package com.philips.training.domain;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	private String name;
	private String genre;
	private String author;

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="publisher_id")
	Publisher publisher;
	
	public Book() {
		
	}

	public Book(String name, String genre, String author) {
		super();
		this.name = name;
		this.genre = genre;
		this.author = author;
		
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	@Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", genre=" + genre + ", author=" + author +"]";
    } 

	
}

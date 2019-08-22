package com.philips.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.philips.training.domain.Book;
import com.philips.training.domain.Publisher;

@Transactional
@Repository
public class BookDAOImpl implements BookDAO{

	@PersistenceContext
	EntityManager em;
	@Override
	public Book save(int publisher_id,Book b) {
		
		Publisher pub = em.find(Publisher.class, publisher_id);
		b.setPublisher(pub);
		em.persist(b);
	
		
		return b;
		
	}
	
	@Override
	public Book findById(int id) {
	
		
		/*return (Book) em.createQuery("select b from Book b where b.id=:id")
		.setParameter("id", id) 
		.getSingleResult();*/
		
		return em.find(Book.class, id);

		

	}
	
	@Override
	public List<Book> findAll(){
		return em.createQuery("select b from Book b")
		.getResultList();
				
		
	}
	
	@Override
	public void deleteById(int id) {
		em.createQuery("delete from Book b  where b.id=:id")
		.setParameter("id", id)
		.executeUpdate();
		System.out.println("SUCCESSFULLY DELETED!!!");
			
	
	}
	
	
	
	@Override
	public List<Book> findByGenreLike(String genre){
		return em.createQuery("select b from Book b where b.genre LIKE :genre")
		.setParameter("genre", genre)
		.getResultList();
				
		
	}
	
	@Override
	public List<Book> findByName(String name){
		return  em.createQuery("select b from Book b where b.name=:name")
		.setParameter("name", name)
		.getResultList();
				
		
	}
	
	@Override
	public List<Book> findByNameLike(String name){
		return em.createQuery("select b from Book b where b.name LIKE :name")
		.setParameter("name", name)
		.getResultList();
				
		
	}
	
	@Override
	public List<Book> findByPublisherName(String name){
		return  em.createQuery("select b from Book b where b.publisher.name LIKE :name")
		.setParameter("name", name)
		.getResultList();
		
	}


	

	
}

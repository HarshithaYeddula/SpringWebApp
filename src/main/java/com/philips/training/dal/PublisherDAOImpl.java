package com.philips.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.philips.training.domain.Publisher;

@Transactional
@Repository
public class PublisherDAOImpl implements PublisherDAO{
	@PersistenceContext
	EntityManager em;
	

	@Override
	public Publisher save(Publisher p) {
	
		em.persist(p);
		return p;
	
		
	}
	
	@Override
	public Publisher findById(int id) {
			
		/*return (Publisher) em.createQuery("select p from Publisher p where p.id=:id")
				.setParameter("id", id).getSingleResult();*/
		return em.find(Publisher.class, id);

	
	}
	
	@Override
	public List<Publisher> findAll(){
		
		return em.createQuery("select p from Publisher p")
                 .getResultList();
	
	}
	
	@Override
	public void deleteById(int id) {
		em.createQuery("delete from Publisher p where p.id=:id").setParameter("id", id)
		.executeUpdate();
		System.out.println("SUCCESSFULLY DELETED!!!");
		
	
	}

	
}

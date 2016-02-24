package com.yash.ejb.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yash.ejb.entity.Book;

/**
 * Session Bean implementation class LibraryPersistentBean
 */
@Stateless(mappedName = "LibraryPersistentBeanRemote")
@Remote(LibraryPersistentBeanRemote.class)
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

	
	//pass persistence unit to entityManager.
	   @PersistenceContext(unitName="EjbComponentPU")
	   private EntityManager entityManager;         
    /**
     * Default constructor. 
     */
   
	@Override
	public void addBook(Book bookName) {
		// TODO Auto-generated method stub
		entityManager.persist(bookName);
	}

	@Override
	public List getBooks() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("From Book").getResultList();
	}

}

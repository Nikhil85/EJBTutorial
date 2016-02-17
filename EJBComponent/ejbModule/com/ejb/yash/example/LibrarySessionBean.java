package com.ejb.yash.example;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class LibrarySessionBean
 */
@Stateless(mappedName = "LibrarySessionBeanRemote")
@Remote(LibrarySessionBeanRemote.class)
public class LibrarySessionBean implements LibrarySessionBeanRemote {
    
	List bookShelf;
    /**
     * Default constructor. 
     */
    public LibrarySessionBean() {
        // TODO Auto-generated constructor stub
    	bookShelf = new ArrayList();
    }

	@Override
	public void addBook(String bookName) {
		// TODO Auto-generated method stub
		bookShelf.add(bookName);
	}

	@Override
	public List getBooks() {
		// TODO Auto-generated method stub
		return bookShelf;
	}

}

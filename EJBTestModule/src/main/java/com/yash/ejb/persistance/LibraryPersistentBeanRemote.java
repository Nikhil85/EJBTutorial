package com.yash.ejb.persistance;

import java.util.List;

import javax.ejb.Remote;

import com.yash.ejb.entity.Book;

@Remote
public interface LibraryPersistentBeanRemote {
	
	 void addBook(Book bookName);

	   List<Book> getBooks();

}

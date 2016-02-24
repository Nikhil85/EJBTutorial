package com.yash.ejb.persistance.test;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.yash.ejb.entity.Book;
import com.yash.ejb.persistance.LibraryPersistentBeanRemote;

public class EJBPersistanceTest {
	
	Scanner brConsoleReader = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		EJBPersistanceTest ejbTester = new EJBPersistanceTest();

		Hashtable<String, String> properties = new Hashtable<String, String>();

		properties.put(Context.INITIAL_CONTEXT_FACTORY,
				"weblogic.jndi.WLInitialContextFactory");
		properties.put(Context.SECURITY_PRINCIPAL, "weblogic");
		properties.put(Context.SECURITY_CREDENTIALS, "welcome1");
		properties.put(Context.PROVIDER_URL, "t3://localhost:7001");

		InitialContext context = new InitialContext(properties);

		ejbTester.testStatelessEjb(context);
	}

	private void showGUI() {
		System.out.println("**********************");
		System.out.println("Welcome to Book Store");
		System.out.println("**********************");
		System.out.print("Options \n1.Add Book\n2.See BookList\n3.Check Stateless and StateFul\n4.Close Client\n Enter Choice:-");
	}

	private void testStatelessEjb(InitialContext ctx) throws Exception {
		try {
			int choice = 1;
			LibraryPersistentBeanRemote libraryBean = (LibraryPersistentBeanRemote) ctx
					.lookup("LibraryPersistentBeanRemote#com.yash.ejb.persistance.LibraryPersistentBeanRemote");
			LibraryPersistentBeanRemote libraryBean1 = (LibraryPersistentBeanRemote) ctx
					.lookup("LibraryPersistentBeanRemote#com.yash.ejb.persistance.LibraryPersistentBeanRemote");
			while (choice != 4) {
				String bookName;
				showGUI();
				choice = brConsoleReader.nextInt();
				if (choice == 1) {
					System.out.print("Enter book name:-");
					bookName = brConsoleReader.next();
					Book book = new Book();
					book.setName(bookName);
					//book.setId(1);
					libraryBean.addBook(book);
				} else if (choice == 2) {
					// break;
					System.out.println("Get book name List");
					List<Book> booksList = libraryBean.getBooks();
					System.out.println("Book(s) entered so far: "
							+ booksList.size());
					for (int i = 0; i < booksList.size(); ++i) {
						System.out.println((i + 1) + ". " + booksList.get(i).getName());
					}

				} /*else if (choice == 3) {
					String decision;
					System.out.println("Check Stateless and Statefull Bean");
					if (libraryBean.equals(libraryBean1)) {
						System.out
								.println("------------Stateless---------SingletonObject------------");
					} else {

						System.out
								.println("------------Staefull---------PrototypeObject------------");
						System.out
								.println("Do you Want to Add book name in new Stateful Object then Enter Yes other wise enter 4 ");
                          decision = brConsoleReader.next();
						if (decision.equalsIgnoreCase("YES")) {
							System.out.print("Enter book name: ");
							bookName = brConsoleReader.next();
							libraryBean1.addBook(bookName);

						}
						System.out.println("Do you Want to See book name list in new Stateful Object then Enter Yes other wise enter 4 ");
						 decision = brConsoleReader.next();
						if (decision.equalsIgnoreCase("YES")) {
							List<String> booksList = libraryBean1.getBooks();
							System.out.println("Book(s) entered so far: "
									+ booksList.size());
							for (int i = 0; i < booksList.size(); ++i) {
								System.out.println((i + 1) + ". "
										+ booksList.get(i));
							}

						}
					}
				} */else if (choice == 4) {
					ctx.close();
					brConsoleReader.close();
					System.out
							.println("#########Close Client#########################");
					break;
				}

			}

		} catch (Exception e) {
			ctx.close();
			brConsoleReader.close();
			System.out.println(e.getMessage());
			e.printStackTrace();

		} finally {
			ctx.close();
			brConsoleReader.close();
		}
	}

}

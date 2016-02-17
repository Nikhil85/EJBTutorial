package com.ejb.yash.example.testclient;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.ejb.yash.example.LibrarySessionBeanRemote;

public class EJBTester {

	Scanner brConsoleReader = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		EJBTester ejbTester = new EJBTester();

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
		System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
	}

	private void testStatelessEjb(InitialContext ctx) {
		try {
			int choice = 1;
			LibrarySessionBeanRemote libraryBean = (LibrarySessionBeanRemote) ctx.lookup("LibrarySessionBeanRemote#com.ejb.yash.example.LibrarySessionBeanRemote");
			while (choice != 2) {
				String bookName;
				showGUI();
				choice = brConsoleReader.nextInt();
				if (choice == 1) {
					System.out.print("Enter book name: ");
					bookName = brConsoleReader.next();
					libraryBean.addBook(bookName);
				} else if (choice == 2) {
					break;
				}
			}
			List<String> booksList = libraryBean.getBooks();
			System.out.println("Book(s) entered so far: " + booksList.size());
			for (int i = 0; i < booksList.size(); ++i) {
				System.out.println((i + 1) + ". " + booksList.get(i));
			}
			LibrarySessionBeanRemote libraryBean1 = (LibrarySessionBeanRemote) ctx
					.lookup("LibrarySessionBeanRemote#com.ejb.yash.example.LibrarySessionBeanRemote");
			List<String> booksList1 = libraryBean1.getBooks();
			System.out
					.println("***Using second lookup to get library stateless object***");
			System.out.println("Book(s) entered so far: " + booksList1.size());
			for (int i = 0; i < booksList1.size(); ++i) {
				System.out.println((i + 1) + ". " + booksList1.get(i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (brConsoleReader != null) {
					brConsoleReader.close();
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
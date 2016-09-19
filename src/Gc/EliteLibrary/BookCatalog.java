package Gc.EliteLibrary;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BookCatalog {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int catalogInput;
		List<Book> bookList = new ArrayList<>();
		String titleKeyword = "";
		String authorKeyword = "";
		String bookTitle = null;
		String bookAuthor = null;
		String bookStatus = null;
		String choice1;
		BookCheckOut bookcheckout = new BookCheckOut();
		BookUpdate bookupdate = new BookUpdate();
		BookTextFile booktextfile = new BookTextFile(
				"C:/Users/User/workspace/midterm-project/src/Gc/EliteLibrary/book.txt");
		System.out.println("Welcome to Gc.eLITELibrary book catalog!");
		Book user;
		int bookId;

		do {
			bookDisplayCatalog();
			catalogInput = sc.nextInt();

			try {

				switch (catalogInput) {
				case 1:
					System.out.println("You have selected the option 1 to list all books");
					bookList = booktextfile.readBookList();

					System.out.println(bookList.size() + "\t" + "Books are there in our GC.eLite library");

					for (Book b : bookList) {
						System.out.println(b);
					}
					break;
				case 2:

					System.out.println("Search Book by author name");

					 bookList = booktextfile.readBookList();
					// Defining List result from the Array list with Book object
					List<Book> result = new ArrayList<Book>();
					// Defining Set string variable titles from Hashset
					Set<String> titles = new HashSet<String>();

					for (Book c : bookList) {
						if (titles.add(c.getBookAuthor())) {
							result.add(c);
							System.out.println(c.getBookAuthor());
						}
					}
					bookList = booktextfile.readBookList();
					String author = bookupdate.searchAuthor(authorKeyword);
					System.out.println(author);

					break;
				case 3:

					System.out.println("Enter the key Word");

					bookList = booktextfile.readBookList();
					// BookUpdate bookupdate = new BookUpdate();

					String title = bookupdate.searchKeyWord(titleKeyword);
					System.out.println(title);

					break;

				case 4:

					bookList = booktextfile.readBookList();

					System.out.println(bookList.size() + "\t" + "List of all Books");

					for (Book b : bookList) {
						System.out.println(b.getBookId() + "   " + b.getBookTitle());
					}

					System.out.println("Enter the Id of the book you want to check out");

					sc = new Scanner(System.in);
					bookId = sc.nextInt();

					user = bookList.get((bookId - 1));

					bookStatus = user.getBookStatus();

					// System.out.println(user.getBookAuthor() + bookStatus);

					if (bookStatus.equals("Checked out")) {
						System.out.println(" Book has been already checked out");

					} else {

						user.setBookStatus("Checked out");
						// System.out.println(bookcheckout.formatCheckOut());

						user.setBookDueDate(bookcheckout.formatCheckOut());
						System.out.println("The book is Successfully Checked out");

						System.out.println(user.getBookStatus() + "\t" + "Due on" + "\t" + user.getBookDueDate());
						// bookList.add((bookId -1),user);
						booktextfile.deleteContent();
						booktextfile.writeBookSet(bookList);

					}

					break;
				case 5:

					bookList = booktextfile.readBookList();

					System.out.println(bookList.size() + "\t" + "List Books in the library ");

					for (Book b : bookList) {
						System.out.println(b.getBookId() + "   " + b.getBookTitle());
					}

					System.out.println("Enter the Id of the book you want to Return");

					sc = new Scanner(System.in);
					bookId = sc.nextInt();

					user = bookList.get((bookId - 1));
					user.setBookDueDate("");
					bookStatus = user.getBookStatus();
					if (bookStatus.equals("OnShelf")) {
						System.out.println(" Book is already Checked in");

					} else {

						// System.out.println(user.getBookTitle()+"\t"
						// +user.getBookAuthor() +"\t"+ bookStatus );
						user.setBookStatus("OnShelf");

						// user.setBookDueDate(bookcheckout.todayCheckinDate());
						// user.setBookStatus(user.getBookDueDate());
						System.out.println("Successfully Checked in on  " + bookcheckout.todayCheckinDate());
						System.out.println(user.getBookTitle() + "\t" + user.getBookStatus());
						// bookList.add((bookId -1),user);
						booktextfile.deleteContent();
						booktextfile.writeBookSet(bookList);
					}
					break;

				case 6:
					System.out.println("Exit");
				default:
					System.out.println("enter valid Input");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print("Do yo want to continue:: ");
			choice1 = sc.next();
		} while (choice1.equalsIgnoreCase("Y"));

	}

	public static void bookDisplayCatalog() {
		System.out.println("pick your option");
		System.out.println("1-list all book");
		System.out.println("2-Search book by author name");
		System.out.println("3-Enter the keyword of the booktitle to search the book");
		System.out.println("4-To checkout");
		System.out.println("5-To return");
	}

}
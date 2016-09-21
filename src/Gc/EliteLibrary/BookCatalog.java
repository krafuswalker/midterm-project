package Gc.EliteLibrary;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
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
		String bookName="";
		String bookTitle = null;
		String bookAuthor = null;
		String bookStatus = null;
		String choice1="y";
		BookCheckOut bookcheckout = new BookCheckOut();
		BookUpdate bookupdate = new BookUpdate();
		BookTextFile booktextfile = new BookTextFile(
				"C:/Users/User/workspace/midterm-project/src/Gc/EliteLibrary/book.txt");

		 

		System.out.println("Welcome to Gc.eLITELibrary book catalog!");
		System.out.println("****************************************");
		Book user=null ;
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

					System.out.println("Enter the book title key Word");
					bookList = booktextfile.readBookList();
					String title = bookupdate.searchKeyWord(titleKeyword);
					System.out.println(title);

					break;

				/**case 4 is checkout module where user inputs book id to check out .If the book staus is checkout the system informs the user that its already checked out
				 * if not the system process the checkout and sets the duedate to be two weeks from that day and updates that in text file
				 */
				
				case 4:

					bookList = booktextfile.readBookList();

					System.out.println(bookList.size() + "\t" + "Books are in catalog");

					for (Book b : bookList) {
						System.out.println(b.getBookId() + "   " + b.getBookTitle());
					}

					System.out.println("Enter the Id of the book you want to check out");

					sc = new Scanner(System.in);
					bookId = sc.nextInt();
 /**
 * user is the object of the class book and we are passing the id to the user to  retrieve the corresponding book
  */
					user = bookList.get((bookId - 1));

					bookStatus = user.getBookStatus();

					if (bookStatus.equals("Checked out")) {
						System.out.println(" Book has been already checked out");

					} else {

						user.setBookStatus("Checked out");
						user.setBookDueDate(bookcheckout.formatCheckOut());
						System.out.println("The book is Successfully Checked out");
						System.out.println(user.getBookStatus() + "\t" + " and Due on" + "\t" + user.getBookDueDate());
						booktextfile.deleteContent();
						booktextfile.writeBookSet(bookList);
					}

					break;
				/**This is the Book return module where the user returns the book and 
				 * if the book is checked in already the library system will inform the user else it will check in and update the text file
				 *  */
				
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

						user.setBookStatus("OnShelf");
						System.out.println("Successfully Checked in on  " + bookcheckout.todayCheckinDate());
						System.out.println(user.getBookTitle() + "\t" + user.getBookStatus());
						booktextfile.deleteContent();
						booktextfile.writeBookSet(bookList);
					}
					break;
				
				case 6:
					System.out.println("Thanks for using elite library system!");
					choice1="n";
			break;
				}
			} catch (Exception e) {
				e.printStackTrace();//to display the  exception details and it helps for debugging
			}
		//System.out.print("Do you want to continue(y/n) ::");
		//choice1=sc.next();
		} while (choice1.equalsIgnoreCase("Y"));

		System.out.println("Good Bye Have a nice day");
        sc.close();
	}

	public static void bookDisplayCatalog() {
		System.out.println("\npick your option");
		System.out.println("1-list all book");
		System.out.println("2-Search book by author name");
		System.out.println("3-Enter the keyword of the booktitle to search the book");
		System.out.println("4-To checkout");
		System.out.println("5-To return");
		System.out.println("6-Exit");
	}

}
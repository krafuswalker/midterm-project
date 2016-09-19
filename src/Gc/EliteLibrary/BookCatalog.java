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
		String bookTitle = null;
		String bookAuthor = null;
		String bookStatus = null;
		String choice1;
		BookCheckOut bookcheckout = new BookCheckOut();
		BookTextFile booktextfile = new BookTextFile("C:/Users/User/workspace/Labs/src/Gc/EliteLibrary/book.txt");
		System.out.println("Welcome to Gc.eLITELibrary book catalog!");
		Book user;
		int bookId;
		
		do{
		bookDisplayCatalog();
		catalogInput = sc.nextInt();
		
		
			try {

				switch (catalogInput) {
				case 1:
					System.out.println("You have selected the option 1 to list all books");
					bookList = booktextfile.readBookList();

					System.out.println(bookList.size() + "\t" + "Books are there on shelf");

					for (Book b : bookList) {
						System.out.println(b);
					}
					break;
				case 2:
					System.out.println("You have selected the option 2 to display author");

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
					break;
				case 3:

                    System.out.println("Enter the key Word");
                    
                    bookList = booktextfile.readBookList();
					BookUpdate bookupdate = new BookUpdate();

					String title = bookupdate.searchKeyWord(titleKeyword);
					System.out.println(title);

					break;

				case 4:
					
					bookList = booktextfile.readBookList();

					System.out.println(bookList.size() + "\t" + "List of all Books");

					for (Book b : bookList) {
						System.out.println(b.getBookId() + "   " + b.getBookTitle());
					}
					
					System.out.println("Select the book you want to check out");
					
								
				    sc = new Scanner(System.in);
					bookId = sc.nextInt();
			
					user = bookList.get((bookId -1));
					
					bookStatus=user.getBookStatus();
					
					//System.out.println(user.getBookAuthor() + bookStatus);
					
					if (bookStatus.equals("Checked Out")){
						System.out.println(" Book has been checked out");
						
					}
					else{
						user.setBookStatus("Checked Out");
						//System.out.println(bookcheckout.formatCheckOut());
						
						user.setBookDueDate(bookcheckout.formatCheckOut());
						
						System.out.println(user.getBookStatus() +"\t" + user.getBookDueDate());
						//bookList.add((bookId -1),user);
						booktextfile.deleteContent();
						booktextfile.writeBookSet(bookList);
						

					}
				
					
					break;
				case 5:
				
					bookList = booktextfile.readBookList();

					System.out.println(bookList.size() + "\t" + "List of all Books");

					for (Book b : bookList) {
						System.out.println(b.getBookId() + "   " + b.getBookTitle());
					}
					
					System.out.println("Enter the book you want to Return");
					
					
				    sc = new Scanner(System.in);
					bookId = sc.nextInt();
					

					user = bookList.get((bookId -1));
					
					bookStatus=user.getBookStatus();
					
					System.out.println(user.getBookAuthor() + bookStatus);
					
					
						user.setBookStatus("On Shef");
						
						user.setBookDueDate("");
						
						System.out.println(user.getBookStatus() + user.getBookDueDate());
						//bookList.add((bookId -1),user);
						booktextfile.deleteContent();
						booktextfile.writeBookSet(bookList);
					
					break;
					
				/*case 6:
					System.out.println("Exit");
				default:
					System.out.println("enter valid Input");*/

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
		System.out.println("2-Display the authors");
		System.out.println("3-Enter the keyword of the booktitle to search the book");
		System.out.println("4-To checkout");
		System.out.println("5-To return");
	}

}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookCatalog {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

				Scanner sc = new Scanner(System.in);

				int catalogInput;
				List<Book> bookList = new ArrayList<>();
				String choice = "yes";

				BookTextFile booktextfile = new BookTextFile("C:/Users/User/workspace/Labs/src/Gc/EliteLibrary/book.txt");
				System.out.println("Welcome to Gc.eLITELibrary book catalog!");
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
						for (Book b : bookList) {
							System.out.println(b.getBookAuthor());
						}
						break;
					case 3:
						System.out.println("You have selected the option 3 to display book keyword");
						bookList = booktextfile.readBookList();
						for (Book b : bookList) {
							System.out.println(b.getBookDescription());
						}
						break;
					case 4:
						System.out.println("You have selected the option4 to checkout books");
						bookList = booktextfile.readBookList();
						for (Book book : bookList) {
							System.out.println(book.getBookStatus());
							System.out.println(book.getBookDueDate());
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			public static void bookDisplayCatalog() {
				System.out.println("pick your option");
				System.out.println("1-list all book");
				System.out.println("2-Display the authors");
				System.out.println("3-Display the keyword");
				System.out.println("4-To checkout");
				System.out.println("5-To return");
			}

	
		
		
	

}

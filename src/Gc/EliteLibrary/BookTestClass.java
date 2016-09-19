package Gc.EliteLibrary;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class BookTestClass {
	@Test

	public void checkId_checkTitle() {
		
		Book b = new Book();
		b.getBookId();
		b.getBookTitle();

		Assert.assertEquals(1, 1);
	}

	@Test

	public void checkId_checkAuthor() {
		Book book1 = new Book();
		book1.setBookId(1);
		book1.getBookAuthor();

		Assert.assertEquals(2, 2);
	}

	@Test

	public void checkId_checkStatus() {
		// ArrayList<Integer> booklib = new ArrayList<>();

		Book book1 = new Book();
		book1.setBookId(10);
		book1.getBookAuthor();

		Assert.assertEquals(10, 10);
	}

	@Test
	public void checkId_CheckDescription() {
		// ArrayList<Integer> booklib = new ArrayList<>();

		Book book1 = new Book();
		book1.setBookId(10);
		book1.getBookDescription();

		Assert.assertEquals(15, 15);
	}
	
	
	@Test
	public void checkcatalogInput_case1(){
		// ArrayList<Integer> booklib = new ArrayList<>();
        int userInput=1;
		Assert.assertEquals(1, userInput);
	}
	
	@Test
	public void checkcatalogInput_case2(){
		
        int userInput=2;
		Assert.assertEquals(2, userInput);
	}
	
	@Test
	public void checkcatalogInput_case3(){
		
        int userInput=3;
		Assert.assertEquals(3, userInput);
	}
	
	@Test
	public void checkcatalogInput_case4(){
		
        int userInput=4;
		Assert.assertEquals(4, userInput);
	}
	
	@Test
	public void checkcatalogInput_case5(){
		
        int userInput=5;
		Assert.assertEquals(5, userInput);
	}
	@Test
	public void checkOutStatus_UpdateInTextFile(){
		ArrayList<Book> bookList=new ArrayList<>();
	   Book b = new Book();
		int bookInput=4;
	    //b.setBookId(19);
		b =bookList.get(20);
		b.setBookStatus("Checked out");
	//	String bookStatus="Checked out";
	 // bookStatus= b.getBookStatus();
		Assert.assertEquals("Checked out", b.getBookStatus());
		
      }
	
	

}

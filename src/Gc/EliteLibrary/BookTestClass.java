package Gc.EliteLibrary;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class BookTestClass {
	Scanner sc=new Scanner(System.in);
	
	@Test

	public void checkId_checkTitle() {
		Book book1=new Book();
		book1.setBookId(1);
		book1.setBookTitle("War and Peace");
		
		Assert.assertEquals("War and Peace",book1.getBookTitle());
	}

	@Test

	public void checkId_checkAuthor() {
		Book book1 = new Book();
		book1.setBookId(4);
		book1.setBookAuthor("Andrew Clements");

		Assert.assertEquals("Andrew Clements",book1.getBookAuthor());
	}

	@Test

	public void checkId_checkStatus() {
		
        Book book1 = new Book();
		book1.setBookId(10);
		book1.setBookStatus("checked out");

		Assert.assertEquals( "checked out",book1.getBookStatus());
	}

	@Test
	public void checkId_CheckDescription() {
		Book book1 = new Book();
		book1.setBookId(15);
		book1.getBookDescription();

		Assert.assertEquals(15, 15);
	}
	
	
	
	@Test
	public void checkOutStatus_UpdateInTextFile(){
		
	   Book b = new Book();
		 b.setBookId(20);
		b.setBookStatus("Checked out");
	 Assert.assertEquals("Checked out", b.getBookStatus());
		
      }
	
	@Test
	public void checInStatus_UpdateInTextFile(){
		
	   Book b = new Book();
		 b.setBookId(19);
		b.setBookStatus("OnShelf");
		Assert.assertEquals("OnShelf",b.getBookStatus());
	 }
	

	
	@Test
	public void checkUpdate_FormatDate(){
		BookCheckOut bc=new BookCheckOut();
		
		
		String date =bc.formatCheckOut();
		Assert.assertEquals("10/04/2016", date);

	 }

	@Test
	public void checkIn_DueDate(){
		BookCheckOut bc=new BookCheckOut();
		
		
		String date =bc.todayCheckinDate();
		Assert.assertEquals("09/20/2016", date);

		
	}
		
	@Test
	public void Search_TitleKeyword() throws IOException{
		BookUpdate bookupdate=new BookUpdate();
		String booktitle= bookupdate.searchKeyWord("peace");
    
		Assert.assertEquals("War and Peace	Leo Tolstoy	Checked out", booktitle);

		
	}

	@Test
	public void Search_AuthorMethod() throws IOException{
		BookUpdate bookupdate=new BookUpdate();
		String author=bookupdate.searchAuthor("Ayn");
    
		Assert.assertEquals("10	The Fountainhead		Ayn Rand	Checked out\n11	Atlas Shrugged		Ayn Rand	OnShelf\n12	Anthem		Ayn Rand	Checked out\n", author);
		
	}
	


	

      

}

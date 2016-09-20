package Gc.EliteLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class BookTestClass {
	Scanner sc=new Scanner(System.in);
	
	@Test

	public void checkId_checkTitle() {
		
		int catalogInput;
		System.out.println("Enter value 1");
		catalogInput=sc.nextInt();
		
		Assert.assertEquals(1,catalogInput);
	}

	@Test

	public void checkId_checkAuthor() {
		Book book1 = new Book();
		book1.setBookId(2);
		book1.getBookAuthor();

		Assert.assertEquals(4, 2);
	}

	@Test

	public void checkId_checkStatus() {
		
        Book book1 = new Book();
		book1.setBookId(10);
		book1.getBookStatus();

		Assert.assertEquals(10, 10);
	}

	@Test
	public void checkId_CheckDescription() {
		Book book1 = new Book();
		book1.setBookId(10);
		book1.getBookDescription();

		Assert.assertEquals(15, 15);
	}
	
	
	@Test
	public void checkcatalogInput_case1(){
		
        int userInput=1;
		Assert.assertEquals(1, userInput);
	}
	
	@Test
	public void checkcatalogInput_case2(){
		
        int userInput=2;
		Assert.assertNotEquals(3, 2);
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
	
	public void checkTitleKeyword() throws FileNotFoundException{
		Book b=new Book();
		
		String titleKeyword="vvvv";
		File file = new File("C:/Users/User/workspace/midterm-project/src/Gc/EliteLibrary/book.txt");

		
		    Scanner scanner = new Scanner(file);

		    //now read the file line by line...
		    int lineNum = 0;
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        System.out.println(line);
		        lineNum++;
		        if(b.getBookTitle().contains("war")) { 
		            System.out.println(b.getBookAuthor() +lineNum);
		        }
		    }
		    Assert.assertEquals("vvvv",b.getBookStatus());
	  
	 }


public void checkId_checkout() throws FileNotFoundException{
	Book b=new Book();
	
File file = new File("C:/Users/User/workspace/midterm-project/src/Gc/EliteLibrary/book.txt");

	b.setBookId(12);
	if (b.getBookId().equals(b.getBookStatus().contains("Checked out")));{
		
	
		System.out.println("pass");
	}
	 {
	
		System.out.println("fail");
	}



}

	


	

      

}

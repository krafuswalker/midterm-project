package Gc.EliteLibrary;

import java.sql.Date;

public class Book {

	private String bookTitle;
	private String bookAuthor;
	private String bookStatus;
	private String bookDescription;
	private String bookDuedate;
	private Integer bookId;
	
	
	public Book() {

        this.bookTitle = null;
        this.bookAuthor = null;
        this.bookStatus = null;
        this.bookDescription = null;
        this.bookDuedate = null;
    }

	
	
    public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookDueDate(String dueDate) {
		this.bookDuedate = dueDate;
	}

	public String getBookDueDate() {
		return bookDuedate;
	}

	@Override
	public String toString() {
		return bookTitle;

	}

    

}

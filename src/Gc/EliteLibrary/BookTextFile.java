package Gc.EliteLibrary;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Hashtable;

/**
 * @author eLITELibrary
 * 
 *         Responsible for reading and writing Book
 *         Tile,Author,Status,Description and DueDate for checked out books to a
 *         file and writes back the status update when the book is written
 */
public class BookTextFile {
	String bookTitle;
	String bookAuthor;
	String bookStatus;

	/**
	 * The path of the file where Books are stored.
	 */
	private Path filePath;

	public BookTextFile(String filePathString) {
		this.filePath = Paths.get(filePathString);
	}

	/**
	 * Constructor that lets you choose a file path.
	 * 
	 * @param filePathString
	 *            path of the file where Books are stored.
	 */

	public BookTextFile() {
		this("C:/Users/User/workspace/midterm-project/src/Gc/EliteLibrary/book.txt");
	}

	/**
	 * Read the file and returns all the Books listed in the file.
	 * 
	 * @return A List of books. If not file exists, it returns an empty list.
	 * @throws RuntimeException
	 *             if something goes wrong while accessing the file.
	 */

	public List<Book> readBookList() throws IOException {

		List<Book> bookList = new ArrayList<>();
		String line = null;
		FileReader fileReader = null;
		int id;
		if (!Files.exists(filePath)) {
			return bookList;
		}

		try {
			File file = filePath.toFile();

			fileReader = new FileReader(file);
			/**
			 * BufferedReader class reads text from a character-input stream,
			 * buffering characters so as to provide for the efficient reading
			 * of characters, arrays and line
			 * 
			 */
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				Book bookObj = new Book();
				String[] result = line.split(",");

				id = Integer.parseInt(result[0]);
				bookObj.setBookId(id);

				bookObj.setBookTitle(result[1]);
				bookObj.setBookAuthor(result[2]);
				bookObj.setBookDescription(result[3]);
				bookObj.setBookStatus(result[4]);

				// If the next column is available(In case of check out date)
				if (result.length > 5) {
					bookObj.setBookDueDate(result[5]);
				}

				bookList.add((id - 1), bookObj);

			}

			return bookList;

		} catch (IOException ex) {
			throw new RuntimeException("unable to read the book list", ex);
		} finally {
			fileReader.close();
		}

	}

	/**
	 * Hear we delete the records and write back from set.We used it to avoid
	 * doubling of the book list when we write back
	 */
	public void deleteContent() {

		File file = filePath.toFile();
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);

			writer.print("");
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes a list of Books to the file.
	 * 
	 * @param The
	 *            list of Books to write.
	 * @throws RuntimeException
	 *             if something goes wrong while accessing the file
	 */
	public void writeBookSet(List allBooks) {

		try {
			if (!Files.exists(filePath)) {
				Files.createFile(filePath);
			}

			List<Book> bookList = allBooks;
			File file1 = filePath.toFile();
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file1, true)));
			StringBuffer sb = new StringBuffer();

			for (Book bookObj : bookList) {
				sb.append(bookObj.getBookId() + "," + bookObj.getBookTitle() + "," + bookObj.getBookAuthor() + ","
						+ bookObj.getBookDescription() + "," + bookObj.getBookStatus());
				/**
				 * hear we are making sure that field is not empty
				 */
				
				if (bookObj.getBookDueDate() != null && bookObj.getBookDueDate().trim() != "") {
					sb.append("," + bookObj.getBookDueDate());
				}

				sb.append("\n");

			}
			writer.print(sb);

			writer.close();

		} catch (IOException ex) {
			// IOException is a checked exception (I have to handle it)
			// RuntimeException is an unchecked exception (I don't have to
			// handle it)
			throw new RuntimeException("unable to write country list");
		}

	}

}
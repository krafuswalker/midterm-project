package Gc.EliteLibrary;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookCheckOut extends Book {

	

	BookTextFile booktextfile = new BookTextFile();

	public BookCheckOut() {
		super();

	}

	

	public String formatCheckOut() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 14); // Adding 14 days
		String output = sdf.format(c.getTime());
		//System.out.println(output);
		return output;

	}

}

package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	public Book(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	//add author into the ArrayList
	public void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
		} else {
			System.out.println("the author has been in the list");
		}
	}
	
	//remove author from the ArrayList
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
		} else{
			System.out.println("The author is not in the list");
		}
	}
}

package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	public Book( String title, String category, float cost , List<String> authors ) {
		
		// TODO Auto-generated constructor stub
		super( title, category, cost);
        this.authors = authors;
		
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
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
	 // Utility method to display all authors (for testing purposes)
    public String getAuthorsAsString() {
        return String.join(", ", authors);
    }
    public String toString() {
        return "Book{" +
               "title='" + super.getTitle() + '\'' +
               ", category='" + super.getCategory() + '\'' +
               ", cost=" + super.getCost() +
               ", author='" + authors + '\'' +
               '}';
    }
}


import java.util.ArrayList;

/**
 * Class to create a library for user books
 * Uses an array list to hold book data
 * @author Joseph
 *
 */
public class UserLibrary {
	private ArrayList<Book> library;
	
	/**
	 * Constructor initializes the Book array list
	 */
	public UserLibrary(){
		library = new ArrayList<Book>();
	}
	
	/**
	 * Add book method to add books to the users library
	 * @param newBook
	 */
	public void addBook(Book newBook){
		library.add(newBook);
	}
	
	/**
	 * Print the book titles for all books in the user library
	 */
	
	public void printBooks(){
		for(Book b : library){
			System.out.println(b.getTitle() + ", " + b.getAuthor());
		}
	}
	
	
}

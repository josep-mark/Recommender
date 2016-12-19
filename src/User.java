import java.util.ArrayList;

/**
 * User clss
 * Holds user id and an array list of book objects
 * @author Joseph
 *
 */
public class User {

	private String id;
	private ArrayList<Book> bookLibrary;
	
	public User(String userId){
		id = userId;
		bookLibrary = new ArrayList<Book>();
	}

	public String getId() {
		return id;
	}

	public ArrayList<Book> getBookLibrary() {
		return bookLibrary;
	}
	
}

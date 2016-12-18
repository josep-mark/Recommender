

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Class to create a Book object from the book crossing data set
 * @author Joseph
 *
 */
public class FindBookInfo {
	private HashMap<String, String> bookMatches;
	private String finalTitle;
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String pubYear;
	private String frontCoverURL;
	
	public FindBookInfo(String theTitle){
		title = theTitle;
		bookMatches = new HashMap<String, String>();
		getInfo();
		findMatch();
		getFinalBook();
	}
	
	/**
	 * Method to search the Book crossing data base for book titles given the user title
	 * Stores those books and their Isbns to a hashmap
	 * Next method will ask the user to choose the book
	 */
	private void getInfo(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("data/books.csv"));
			
			String line;
			while((line = reader.readLine()) != null){
				String[] info = line.split(",");
				String titleTest = title.toLowerCase();
				String test = info[1].toLowerCase();
				if(test.contains(titleTest)){
					bookMatches.put(info[1], info[0]);
				}
			}
			
			reader.close();
				
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to retrieve book data once a specific book is chosen
	 */
	private void getFinalBook(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("data/books.csv"));
			
			String line;
			while((line = reader.readLine()) != null){
				String[] info = line.split(",");
				String titleTest = finalTitle.toLowerCase();
				String test = info[1].toLowerCase();
				if(test.equalsIgnoreCase(titleTest)){
					isbn = info[0];
					title = info[1];
					author = info[2];
					pubYear = info[3];
					publisher = info[4];
					frontCoverURL = info[7];
				}
			}
			
			reader.close();
				
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to create a new book based on the given title from the user
	 * @return
	 */
	public Book getBook(){
		Book newBook = new Book(isbn, title, author, publisher, pubYear, frontCoverURL);
		return newBook;
	}
	
	/**
	 * Method that asks the user to specify which book they would choose from a book search
	 */
	private void findMatch(){
		System.out.println("We found the following books matching your entry: ");
		Set<String> keySet = bookMatches.keySet();
		for(String s : keySet){
			System.out.println(s);
		}
//		System.out.println(keySet);
		System.out.println("Please enter the specific title: ");
		Scanner in = new Scanner(System.in);
		finalTitle = in.nextLine(); 
		in.close();
	}

}

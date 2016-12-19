import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FindBookFromIsbn {
	
	private String finalTitle;
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String pubYear;
	private String frontCoverURL;
	
	public FindBookFromIsbn(String theIsbn){
		isbn = theIsbn;
		findMatch();
	}
	
	private void findMatch(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("data/books.csv"));
			
			String line;
			while((line = reader.readLine()) != null){
				String[] info = line.split(",");
				String isbnTest = finalTitle.toLowerCase();
				String test = info[0];
				if(test.equalsIgnoreCase(isbnTest)){
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
	 * Get book from Isbn
	 * @return
	 */
	public Book getBook(){
		Book newBook = new Book(isbn, title, author, publisher, pubYear, frontCoverURL);
		return newBook;
	}

}

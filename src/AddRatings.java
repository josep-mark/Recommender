import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class adds a users ratings to our dataset
 * @author Joseph
 *
 */
public class AddRatings {
	private ArrayList<String> rating;
	
	/**
	 * Constructor
	 * @param userRating ArrayList containing userid, book isbn, and rating 
	 */
	public AddRatings(ArrayList<String> userRating){
		rating = userRating;
		add();
	}
	
	
	/**
	 * Append to the file using buffered writer
	 */
	private void add(){
		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/book-ratingsV2.csv", true));
			bw.write(rating.get(0)+ "," +rating.get(1) + "," + rating.get(2));
			bw.newLine();
			bw.flush();
			bw.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}

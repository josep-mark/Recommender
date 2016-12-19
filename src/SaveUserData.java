import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONObject;

/**
 * This is a class to save user data in a json file
 * It uses the Maven JSON simple to create a json file
 * @author Joseph
 *
 */
public class SaveUserData {
	private String user;
	private ArrayList<Book> userBooks;
	
	public SaveUserData(String id, ArrayList<Book> books){
		user = id;
		userBooks = books;
	}
	
	private void save(){
		JSONObject obj = new JSONObject();
		
		obj.put(user, userBooks);
		
		try{
			FileWriter file = new FileWriter("data/userdata.json");
			file.write(obj.toString());
			file.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}

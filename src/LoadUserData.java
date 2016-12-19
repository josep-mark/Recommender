import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.*;
import org.codehaus.jackson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import scala.util.parsing.json.JSON;
/**
 * This class finds the users data in a json file and loads their information
 * @author Joseph
 *
 */
public class LoadUserData {
	
	private String id;
	private User user;
	private ArrayList<String> bookIsbn;
	private ArrayList<String> ratings;
	
	public LoadUserData(String userId){
		id = userId;
		user = new User(id);
		bookIsbn = new ArrayList<String>();
		getData();
	}
	
	private void getData(){
		
		try{
			BufferedReader fr = new BufferedReader(new FileReader("data/userdata.csv"));
					
			String line;
			while((line = fr.readLine()) != null){
				String[] info = line.split(",");
				if (info[0] == id){
					for(int i = 1; i< info.length; i += 2){
						bookIsbn.add(info[i]);
					}
					for(int i = 2; i < info.length; i += 2){
						ratings.add(info[i]);
					}
				}
				
			}
			fr.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void findBooks(){
		for (String s: bookIsbn){
			FindBookFromIsbn book = new FindBookFromIsbn(s);
			Book newBook = book.getBook();
			user.addBookToLibrary(newBook);
		}
	}
	
	public User getUser(){
		return user;
	}
	

}

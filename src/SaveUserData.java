import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This is a class to save user data in a json file
 * It uses the Maven JSON simple to create a json file
 * @author Joseph
 *
 */
public class SaveUserData {
	private User user;
	private String id;
	private ArrayList<Book> userBooks;
	ArrayList<String> holder;
	
	
	public SaveUserData(User newUser){
		user = newUser;
		userBooks = user.getBookLibrary();
		id = user.getId();
		holder = new ArrayList<String>();
		save();
	}
	
	private void save(){		
		String data = id + ",";
		String l = "";
		String m = "";
		String q = "";
		for(Book b : userBooks){
			l = b.getIsbn();
			m = b.getRating();
			q = l + "," + m + ",";
			data += q;
		}
		data += "\n";
		
		try{
			BufferedReader fr = new BufferedReader(new FileReader("data/userdata.csv"));
			BufferedWriter file = new BufferedWriter(new FileWriter("data/userdata.csv"));
			
			String line;
			while((line = fr.readLine()) != null){
				holder.add(line);
//				String[] info = line.split(",");
//				if (info[0] == id){
//					file.write(data);
//				}
				
			}
			file.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		replaceLine(data);
		rewrite();
	}
	
	private void replaceLine(String data){
		boolean alreadyInFile = false;
		for(String s : holder){
			String[] test = s.split(",");
			if (test[0].equals(id)){
				alreadyInFile = true;
				s = data;
			}
		}
		
		if(alreadyInFile == false){
			holder.add(data);
		}
	}
	
	private void rewrite(){
		try{
			BufferedWriter file = new BufferedWriter(new FileWriter("data/userdata.csv"));
			
			for (String s : holder){
				file.write(s);
				
			}
			file.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}

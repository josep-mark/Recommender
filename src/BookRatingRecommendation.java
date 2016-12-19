import javax.swing.JOptionPane;

import org.apache.mahout.cf.taste.common.TasteException;

import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookRatingRecommendation extends JFrame{
	private User user;
	ArrayList<String> titles;
	private HashMap<String, String> isbnToTitle;
	private HashMap<String, String> idToIsbn;
	private HashMap<String, String> isbnToIds;

	public BookRatingRecommendation(User newUser){
		user = newUser;
		StoreBookData data = new StoreBookData("data/books.csv", "data/isbn-id-map.csv");
		isbnToTitle = data.getIsbnToTitle();
		idToIsbn = data.getIdToIsbn();
		isbnToIds = data.getIsbnToIds();
				
	}
	
	public ArrayList<String> RateRecommend() {
		
		ArrayList<String> recommendation = new ArrayList<String>();
		
		String userId = user.getId();
		
		try {
			UserRecommender userRec = new UserRecommender(userId, isbnToIds, isbnToTitle);
			titles = userRec.getTitles();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TasteException e) {
			e.printStackTrace();
		}
		
		if (titles.isEmpty()){
			titles.add("sorry we didn't find any recommendations");
			return titles;
		}
		
		
		return titles;
		
	}
	
	
}

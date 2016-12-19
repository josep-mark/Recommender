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

public class RecommendOneBook extends JFrame{
private HashMap<String, String> isbnToTitle;
private HashMap<String, String> idToIsbn;
private HashMap<String, String> isbnToIds;

	public RecommendOneBook(){
		
		StoreBookData data = new StoreBookData("data/books.csv", "data/isbn-id-map.csv");
		isbnToTitle = data.getIsbnToTitle();
		idToIsbn = data.getIdToIsbn();
		isbnToIds = data.getIsbnToIds();
				
	}
	
	public ArrayList<String> BookInput() {
		ArrayList<String> recommendation = new ArrayList<String>();
		String bookname = JOptionPane.showInputDialog("Enter the name of a book for the system to match");
		
		FindMatches matches = new FindMatches(bookname);
		ArrayList<String> options = matches.getMatches();
		RecommendationDisplay display = new RecommendationDisplay(options);
		display.setVisible(true);
		display.setSize(250, 400);
		display.setTitle("Please enter one of these options");
		//
		String bookname1 = JOptionPane.showInputDialog("Please enter exactly one of the options in the display window");
		FindBookInfo findBook = new FindBookInfo(bookname1);
		Book book = findBook.getBook();
		ItemRecommender items;
		try {
			items = new ItemRecommender(book.getIsbn(), idToIsbn, isbnToIds, isbnToTitle);
			recommendation = items.getTitles();
		} catch (IOException | TasteException e) {
			e.printStackTrace();
		}
		
		return recommendation;
		
	}
	
	
}

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
		String bookname = JOptionPane.showInputDialog("Enter the name of a book");
		
		FindBookInfo findBook = new FindBookInfo(bookname);
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

import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookRatingWindow extends JFrame{
	
	private String[] rating = new String[3];
	private User user;
	
	public BookRatingWindow(User userName){
		user = userName;
		
	}
	
	public void RateYourBook(){
		
	
		String title = JOptionPane.showInputDialog("Enter the book title");
		FindMatches matches = new FindMatches(title);
		
		ArrayList<String> bookmatch = matches.getMatches();
		RecommendationDisplay display = new RecommendationDisplay(bookmatch);
		
		String exacttitle = JOptionPane.showInputDialog("Enter the exact book title match");
		String rate = JOptionPane.showInputDialog("Enter your rating out of 10");
		
		FindBookInfo book1 = new FindBookInfo(exacttitle);
		Book newBook = book1.getBook();
		newBook.addRating(rate);
		user.addBookToLibrary(newBook);
		
		ArrayList<Book> library = user.getBookLibrary();
		boolean found = false;
		
		for(Book book : library){
			if (book.getTitle().equalsIgnoreCase(title)){
				Book reviewBook = book;
				found = true;
				rating[0] = user.getId();
				rating[1] = reviewBook.getIsbn();
				rating[2] = rate;
				reviewBook.addRating(rate);
				break;
			}
		}
		
		if (found == false){
			FindBookInfo find = new FindBookInfo(title);
			Book revBook = find.getBook();
			rating[0] = user.getId();
			rating[1] = revBook.getIsbn();
			rating[2] = rate;
			revBook.addRating(rate);
			library.add(revBook);
		}
		
		
		AddRatings addRat = new AddRatings(rating);
		addRat.add();
	}
	
	
	
	
}

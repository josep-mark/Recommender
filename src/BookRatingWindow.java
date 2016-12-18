import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookRatingWindow extends JFrame{

	public BookRatingWindow(){
		
	}
	
	public String[] RateYourBook(){
		
		String bookname = JOptionPane.showInputDialog("Enter the name of the book");
		String rating = JOptionPane.showInputDialog("Enter your rating");
		
		String[] rate = {bookname, rating};
		
		return rate;
	}
	
	
	
	
}

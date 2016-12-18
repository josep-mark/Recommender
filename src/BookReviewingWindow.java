import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookReviewingWindow extends JFrame{

	public BookReviewingWindow(){
		
	}
	
	public String[] RateYourBook(){
		
		String bookname = JOptionPane.showInputDialog("Enter the name of the book");
		String review = JOptionPane.showInputDialog("Enter your review");
		
		String[] rate = {bookname, review};
		
		return rate;
	}
	
	
	
	
}

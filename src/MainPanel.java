import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class MainPanel extends JFrame {

	private JLabel label1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private String username;
	private User user;
	
	public MainPanel(int account){
		username = Integer.toString(account);
		LoadUserData getData = new LoadUserData(username);
		user = getData.getUser();
		
		setLayout(new FlowLayout());
		label1 = new JLabel ("Welcome, user " + username);
		add(label1);
		
		button1 = new JButton("View your books");
		add(button1);
		
		button2 = new JButton("Rate your books");
		add(button2);
		
		button3 = new JButton("Write a review");
		add(button3);
		
		button4 = new JButton("Get a book recommendation");
		add(button4);
		
		button5 = new JButton("Get a user based recommendation");
		add(button5);
		
		event e = new event();
		button1.addActionListener(e);
		
		event2 f = new event2();
		button2.addActionListener(f);
		
		event3 g = new event3();
		button3.addActionListener(g);
		
		event4 h = new event4();
		button4.addActionListener(h);
		
		event5 i = new event5();
		button5.addActionListener(i);
	}
	
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			label1.setText("Viewing your books");
			ViewingBooksWindow viewbook = new ViewingBooksWindow(username);
			viewbook.setVisible(true);
			viewbook.setSize(250, 400);
			viewbook.setTitle("Here are your book list");
//more actions			
		}		
	}
	
	public class event2 implements ActionListener{
		public void actionPerformed(ActionEvent f){
			label1.setText("Rating a book");
			BookRatingWindow trys = new BookRatingWindow(user);
			trys.RateYourBook();
//more actions			
		}		
	}
	
	public class event3 implements ActionListener{
		public void actionPerformed(ActionEvent g){
			label1.setText("Writing a review");
			
//more actions			
		}		
	}
	
	public class event4 implements ActionListener{
		public void actionPerformed(ActionEvent h){
			label1.setText("Getting a recommendation");
			RecommendOneBook recommendation = new RecommendOneBook();
			ArrayList<String> result = recommendation.BookInput();
			BookRecommendationWindow tryout = new BookRecommendationWindow(result);
			tryout.setVisible(true);
			tryout.setSize(250, 400);
			tryout.setTitle("Here are the books recommended");
//more actions			
		}		
	}
	
	public class event5 implements ActionListener{
		public void actionPerformed(ActionEvent i){
			label1.setText("Get a user based recommendation");
//more actions			
		}		
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MainPanel tryout = new MainPanel();
		
//		tryout.setVisible(true);
//		tryout.setSize(250, 400);
//		tryout.setTitle("Welcome to our book system");
//	}
	
}

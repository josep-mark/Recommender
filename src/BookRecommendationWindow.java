import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class BookRecommendationWindow extends JFrame {
	
	private ArrayList<JLabel> books;
	private JLabel book;
	private JButton closebutton;
	
	
	public BookRecommendationWindow(ArrayList<String> bookinput){
		this.setSize(400,  400);
		setLayout(new FlowLayout());		
		
		for (int i = 0; i < bookinput.size(); i++){
			book = new JLabel();
			book.setText(bookinput.get(i));
			books.add(book);
		}
		
		for (int i = 0; i < books.size(); i++){
			add(books.get(i));
		}
			
		closebutton = new JButton("Close window");
		add(closebutton);		
		event e = new event();
		closebutton.addActionListener(e);
	}
	
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("event");
			setVisible(false);
		}
	}
	
	
}

	
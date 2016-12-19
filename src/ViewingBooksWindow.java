import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class ViewingBooksWindow extends JFrame {
	
	private ArrayList<JLabel> books = new ArrayList<JLabel>();
	private JLabel book;
	private JButton closebutton;
	private ArrayList<String> booklist = new ArrayList<String>();
	private ArrayList<Book> bookobject = new ArrayList<Book>(); 
	public ViewingBooksWindow(User user){
		
		bookobject = user.getBookLibrary();
		
		for (Book object : bookobject){
			String title = object.getTitle();
			booklist.add(title);
		}
		
		this.setSize(400, 400);
		setLayout(new FlowLayout());
		
		for (int i = 0; i < booklist.size(); i++){
			book = new JLabel();
			book.setText(booklist.get(i));
			books.add(book);
		}
		
		System.out.println(books);
		
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

	
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;


public class RecommendationDisplay extends JFrame {

	private JLabel book;
	private JButton closebutton;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	
	public RecommendationDisplay(ArrayList<String> booklist){
		
		this.setSize(400,400);
		setLayout(new FlowLayout());
		
		for (String bookname : booklist){
			book = new JLabel();
			book.setText(bookname);
			labels.add(book);
		}
		
		for (JLabel book : labels){
			add(book);
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

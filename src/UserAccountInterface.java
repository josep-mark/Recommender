import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserAccountInterface extends JFrame {

	private JLabel label1;
	private JButton button1;
	private JTextField text1;
	private JButton button2;
	
	public UserAccountInterface(){
		setLayout(new FlowLayout());
		label1 = new JLabel ("Welcome!");
		add(label1);
		
		button1 = new JButton("Login");
		add(button1);
		
		button2 = new JButton("Create New Account");
		add(button2);
		
		event e = new event();
		button1.addActionListener(e);
		
		event2 f = new event2();
		button2.addActionListener(f);
	}
	
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			label1.setText("Loging in");
			LoginInterface trys = new LoginInterface();
			trys.UserLogin();
		}		
	}
	
	public class event2 implements ActionListener{
		public void actionPerformed(ActionEvent f){
			label1.setText("Creating username");
			NewUserInterface tryss = new NewUserInterface();
			tryss.NewUser();
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserAccountInterface tryout = new UserAccountInterface();
		tryout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tryout.setVisible(true);
		tryout.setSize(250, 400);
		tryout.setTitle("Welcome to our book system");
	}
	
}

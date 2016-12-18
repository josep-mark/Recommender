import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewUserInterface extends JFrame{

	public NewUserInterface(){
		
			
	}
	
	public int NewUser(){
		
		String username = JOptionPane.showInputDialog("Enter new username");
		String password = JOptionPane.showInputDialog("Enter new password");
		
		int us = Integer.parseInt(username);
		int ps = Integer.parseInt(password);
		
		CreateUser create = new CreateUser();
		int result = create.CreatNewUser(us, ps);
		
		if (result == 1){		
			JOptionPane.showMessageDialog(null, "new account created");
		}
		else if (result == 0){
			JOptionPane.showMessageDialog(null, "account already exists. please login");
		}
		return 1;
	}
	
	
}

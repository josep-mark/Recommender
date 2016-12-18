import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserInterfacePractice extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fn = JOptionPane.showInputDialog("Enter your number1");
		String sn = JOptionPane.showInputDialog("Enter number2");
		
		JOptionPane.showMessageDialog(null, "The answer is" + fn + sn);
		
		
		
	}

	
	
	
}

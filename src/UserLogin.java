import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UserLogin {

	private HashMap<Integer, Integer> useraccount = new HashMap<Integer, Integer>();
	private File input;
	private Scanner scan;
	private int username;
	private int password;
	
	public UserLogin(){
		try{
			input = new File("UserAccountPassword.txt");
			scan = new Scanner(input);
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("system error, please contact provider");
		}
	}
	
	public int userlogin(int accountinput, int passwordinput){
		
		while (scan.hasNextLine()){
			username = scan.nextInt();
			password = scan.nextInt();
			useraccount.put(username, password);
		}
		
		if (useraccount.containsKey(accountinput)){
			if (passwordinput == useraccount.get(accountinput)){
			return 1;
			}
			else{
				return 2;
			}
		}
		else {
			return 0;
		}
		
	}
	
	
}

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class CreateUser {

	private HashMap<Integer, Integer> useraccount = new HashMap<Integer, Integer>();
	private File input;
	private Scanner scan;
	private PrintWriter print;
	private int username;
	private int password;
	
	public CreateUser(){
		
	}
	
	public int CreatNewUser(int newusername, int newpassword){
		try{
			input = new File("UserAccountPassword.txt");
			scan = new Scanner(input);
			
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("system error, please contact provider");
		}
		while (scan.hasNextLine()){
			username = scan.nextInt();
			password = scan.nextInt();
			useraccount.put(username, password);
		}
		try{
			print = new PrintWriter(new FileWriter("UserAccountPassword.txt", true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		if (useraccount.containsKey(newusername)){
			return 0;
		}
		else {
			print.print(username + " ");
			print.println(password);
			print.close();
			return 1;
		}
		
	}
	
	
}

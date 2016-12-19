import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;



public class BookList {

	private File input;
	private Scanner scan;
	private ArrayList<String> booklist = new ArrayList<String>();
	private String bookstorage;
	
	public BookList(String username){
		
		try{
			input = new File(username+".txt");
			scan = new Scanner(input);
		}
		catch (FileNotFoundException fnfe){
			System.out.println("system error, please contact provider");
		}
		
		while (scan.hasNextLine()){
			bookstorage = scan.nextLine();
			booklist.add(bookstorage);
			scan.nextLine();
			scan.nextLine();
		}
		
	}
	
	public ArrayList<String> getnames(){
		
		return booklist;
		
	}
}

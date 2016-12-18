import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This will test various file input/output methods.
 * @author swapneel
 *
 */
public class FilesFun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File inputFile = new File("max-soha.txt");

			Scanner in = new Scanner(inputFile);
			PrintWriter out = new PrintWriter("updated-max-soha.txt");
			
			
			while (in.hasNextLine()) {
				String item = in.nextLine();
				
//				System.out.println(item);
				
//				double price = in.nextDouble();
//				in.nextLine();
				
				String price = in.nextLine();
				double originalPrice = Double.parseDouble(price);
				
//				System.out.println(originalPrice);
				
//				System.out.println(item + ": " + originalPrice);
				
				double newPrice = originalPrice + 500;
				
				out.println(item);
				out.println(newPrice);
//				out.flush();
			}
			
			in.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		in.nextLine();

	}

}



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataFix {
	
	
	private String inputFile;
	private String outputFile;
	
	public DataFix(String inFile, String outFile){
		inputFile = inFile;
		outputFile = outFile;
		fix();
	}
	
	private void fix(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			
			String line;
			while((line = reader.readLine()) != null){
				line = line.replace("\"", "");
				line = line.replaceAll(";", ",");
				line = line.replaceAll("/", "");
				writer.write(line + "\n");
			}
			
			reader.close();
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
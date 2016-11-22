import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class ReadFile {

	private File file;	

	public ReadFile(String file_path) {
		file = new File(file_path);
	}

	public String[] OpenFile() throws IOException {
		try {
			FileReader file_to_read = new FileReader(file.getAbsoluteFile());
			BufferedReader textReader = new BufferedReader (file_to_read);
			
			int numberOfLines = readLines();
			String[] textData = new String[numberOfLines];
			
			for (int i = 0; i < numberOfLines; ++i) {
				textData[i] = textReader.readLine();
			}
			textReader.close();
			return textData;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
		
	private int readLines() throws IOException {
		
		FileReader file_to_read = new FileReader(file.getAbsoluteFile());
		BufferedReader textReader = new BufferedReader(file_to_read);		
	
		String aLine;
		int numberOfLines = 0;
		
		while ((aLine = textReader.readLine()) != null) {
			numberOfLines++;
		}
		textReader.close();
		
		return numberOfLines;
	}
	
        public void WriteFile(String Word) throws IOException {
		try { 
			FileWriter file_to_write = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter textReader = new BufferedWriter(file_to_write);
			textReader.write(Word);
			textReader.close();		
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

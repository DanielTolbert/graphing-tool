package ClientAsisstants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader extends FileHandler{

	private static String[] text;
	private static String contents;
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			execWriter();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		readFile(chooseFile());
		
	}
	
	public static String chooseFile() {
		
		ArrayList<String> files = new ArrayList<String>();
		
		for(File file: getFiles(file)) {
			
			if(file.getName().contains(".csv") || file.getName().contains(".txt")) {
				System.out.println(file.getName());
				files.add(file.getName());
			}
		}
		
		do {
			System.out.println("Choose a file");
			String answer = s.next();
			for(String fileName: files) {
				if(fileName.contains(answer)) {
					System.out.println(fileName + "?");
					if(s.next().substring(0, 1).equalsIgnoreCase("y")) {
						return fileName;
					}
				}
				System.out.println("No matching files found");
				break;
			}
		}while(true);
		
		
	}
	
	public static void readFile(String fileName) {
		
		String csvFile = fileName;
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		
		try {
			
			br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				
				text = line.split(splitBy);
				for(String s: text) {
					contents += s;
				}
				contents += "\n";
				
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if( br != null) {
				try {
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(contents);
		
		
		
	}
	
	
	
	
}

package ClientAsisstants;

import java.io.File;
import java.io.IOException;

public class FileHandler {
	
	public static File file = new File(".");
	
	public static void main(String[] args) {
		
		
		
	}
	
	public static void listFiles(File dir) {
		
		File[] list = dir.listFiles();
		for(File f: list) {
			if(f.isDirectory()) {
				listFiles(f);
			}
			
			if(f.isFile()) {
				System.out.println(f.getName());
			}
		}
		
	}
	
	public static File[] getFiles(File dir) {
		File[] listOfFiles = dir.listFiles();
		return listOfFiles;
	}
	
	public static void execWriter() throws InterruptedException {
		Process p;
		
		try {
			p = Runtime.getRuntime().exec("New Text Document.bat");
//			System.out.println(p.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		
		
			
		
	}

}

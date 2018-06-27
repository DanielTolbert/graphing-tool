package ClientAsisstants;

import java.io.File;

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

}

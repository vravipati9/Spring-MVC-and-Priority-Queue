package java7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.JarFile;

/*
 * Try with Resources does automatically close the resources. so no need to close them in finally block.
 */
public class TryWithResources {

	public static void main(String[] args) {
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("src");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// java 7
		try(FileInputStream in = new FileInputStream("src"); OutputStream out = new FileOutputStream("dest")) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

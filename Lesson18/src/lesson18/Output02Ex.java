package lesson18;

import java.io.FileOutputStream;
import java.io.IOException;

public class Output02Ex {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("output2.txt");
		for(int i = 'A'; i <= 'Z'; i++) {
			fos.write(i);	
//			System.out.write(i);
		}
		fos.write('\n'); //개행 10번
		for(int i = 'a'; i <= 'z'; i++) {
			fos.write(i);	
	}
		fos.write('\n');
		for(int i = 'A'; i <= 'Z'; i++) {
		fos.write(i);	
		
		}
		fos.close();
	}
}
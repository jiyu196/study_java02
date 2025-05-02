package utils;

import java.util.Scanner;

public class BankUtils {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static String nextLine(String msg) {
		System.out.print(msg);
		return scanner.nextLine();
		
	}
	
	public static int nextInt(String msg) {
		return Integer.parseInt(nextLine(msg));   //nextint는 버퍼이슈때문에 사용안함
		
	}
	
	public static long nextLong(String msg) {
<<<<<<< HEAD
		return Integer.parseInt(nextLine(msg));   //nextint는 버퍼이슈때문에 사용안함
=======
		return Integer.parseInt(nextLine(msg));  
>>>>>>> 20fd4608ef95abc23d59b50b7dff181ab1e16099
		
	}
	
	
	public static boolean nextConfirm(String msg) {
		String s = nextLine(msg + "[y/n]");
		return s.equalsIgnoreCase("y") || s.equals("yes");
	}
}

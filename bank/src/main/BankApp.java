package main;

import service.BankService;
import utils.BankUtils;

public class BankApp {
	public static void main(String[] args) {
		try {
		while(true) {
			System.out.println(" ┏━━━━┓┃┏┓┃┃┃━━┓┃━━━┓━┓┃┏┓┓┏━┓\r\n"
					+ "┃┏┓┏┓┃┃┃┃┃┃┃┏┓┃┃┏━┓┃┃┗┓┃┃┃┃┏┛\r\n"
					+ "┗┛┃┃┗┛┃┃┃┃┃┃┗┛┗┓┃┃┃┃┏┓┗┛┃┗┛┛┃\r\n"
					+ "┃┃┃┃┃┃┓┃┃┃┃┃┏━┓┃┗━┛┃┃┗┓┃┃┏┓┃┃\r\n"
					+ "┃┏┛┗┓┃┗┛┃┃┃┃┗━┛┃┏━┓┃┃┃┃┃┃┃┃┗┓\r\n"
					+ "┃┗━━┛┃━━┛┃┃┃━━━┛┛┃┗┛┛┃┗━┛┛┗━┛\r\n"
					+ "┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃\r\n"
					+ "┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃┃\r\n"
					+ "");
			System.out.println("===============================================");
			BankService.getInstance().menu();
			
			
			}
		} 
		catch (NumberFormatException e) {
		System.out.println("정확한 숫자를 입력하시오.");
		} 
		catch (IllegalArgumentException e) {
		System.out.println(e.getMessage());
		}
	}
}

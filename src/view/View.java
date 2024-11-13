package view;

import java.util.Scanner;

public class View {
	
	private Scanner scanner = new Scanner(System.in);
	
	public void print(String message) {
		System.out.println(message);
	}
	
	public String read() {
		return this.scanner.next();
	}
}

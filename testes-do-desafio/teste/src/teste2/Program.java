package teste2;

import java.io.IOException;

public class Program {
	
	public static void main(String[] args) throws IOException {
  	  
		for(int i=1; i<=8;i++) {
			for(int j=1; j<=8; j++) {
				System.out.print(i);
				System.out.print(j);
				System.out.print(" ");
			}
			System.out.println();
		}
  	}
}

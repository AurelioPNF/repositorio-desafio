package teste7;

import java.util.Locale;
import java.util.Scanner;

public class DIO {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en","US"));
		Scanner leitor = new Scanner(System.in);
		String print = "";
		double N = leitor.nextDouble();
		if(!String.valueOf(N).startsWith("-")) {
			print += "+";
		}
		print += String.format("%.4E",N);
		System.out.println(String.format((String.valueOf(N).startsWith("-") ? "" : "+") + "%.4E", N));
	}
}

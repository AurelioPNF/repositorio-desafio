package teste3;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		NumberFormat nformat = NumberFormat.getInstance(Locale.GERMAN);
		Scanner scan = new Scanner(System.in);

		// declare suas variaveis do tipo double
		double raio = 0.0d;
		// continue a solucao
		try {
			raio = scan.nextDouble();
		}catch(InputMismatchException err){
			raio = nformat.parse(scan.nextLine()).doubleValue();
		}
		
		double area = 3.14159 * (Math.pow(raio, 2));

		System.out.printf("A=%.4f\n", area);
		scan.close();
	}

}

package teste4;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class DIO {

	public static void main(String[] args) throws IOException, ParseException {
		NumberFormat nformat = NumberFormat.getInstance(Locale.GERMAN);
    	Scanner leitor = new Scanner(System.in);
    	double A = 0.0;
    	double B = 0.0;
    	
    	try {
    		A = leitor.nextDouble();
		}catch(InputMismatchException err){
			A = nformat.parse(leitor.nextLine()).doubleValue();
		}
    	try {
    		B = leitor.nextDouble();
    	}catch(InputMismatchException err){
    		B = nformat.parse(leitor.nextLine()).doubleValue();
    	}
    	
    	
    	double incremento = 0.0;
    	//Escreva aqui a sua lógica
    	incremento = ((B-A)/A)*100;
    	System.out.println(incremento);
    	
    }

}

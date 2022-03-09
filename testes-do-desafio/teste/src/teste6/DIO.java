package teste6;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Locale;

public class DIO {
	
    public static void main(String[] args) throws IOException {
    	Locale.setDefault(new Locale("en","US"));
		Scanner leitor = new Scanner(System.in).useLocale(Locale.US);
		
		double N = leitor.nextDouble();
		
		imprimir(N);
		leitor.close();
    }
    
    private static int pegaExpoente(double N) {
    	int expoente = 0;
    	if(N>10) {
    		while(N>10) {
        		N /=10;
        		expoente +=1;
        	}
    	}else if(N<0 && N>-1 || N>0 && N<1) {
    		while(N<0) {
        		N *=10;
        		expoente -=1;
        	}
    	}
    	
    	return expoente;
    }
    
    private static double ajustaN(double N) {
    	double novoN = N;
    	if(N>10) {
    		while(novoN>10) {
        		novoN /=10;
        	}
    	}else if(N<0 && N>-1 || N>0 && N<1) {
    		while(novoN<0) {
        		novoN *=10;
        	}
    	}
    	
    	return novoN;
    }
    
    private static double formatar(double N) {
    	DecimalFormat df = new DecimalFormat("#.####");
    	df.setRoundingMode(RoundingMode.HALF_UP);
    	double D = Double.valueOf(df.format(N));
    	return D;
    }

	private static boolean pegaSinal(double N) {
		if(N>0) {
			return true;
		}else {
			return false;
		}
	}
	
	private static int ajusta0(double N) {
		int numeroZeros = 0;
		String stringN = String.valueOf(N);
		numeroZeros = 4 - stringN.length() - stringN.indexOf(".");
		if(numeroZeros<0) {
			numeroZeros = 0;
		}
		return numeroZeros;
	}
	
	
	private static void imprimir(double N) {
		int expoente = 0;
		double numeroFormatado = formatar(N);
		if(N>10 || N<0 && N>-1 || N>0 && N<1) {
			expoente = pegaExpoente(N);
			numeroFormatado = formatar(ajustaN(N));
		}
		int numeroZeros = ajusta0(N);
		String print = "";
		if(pegaSinal(N)) {
			print += "+";
		}
		print += String.format("%.4f", numeroFormatado);
		for(int i = 0 ; i<numeroZeros; i++) {
			print += "0";
		}
		print += String.format("E%d", expoente);
		if(expoente==0) {
			print += "0";
		}
		System.out.println(print);
		
	}
	
}
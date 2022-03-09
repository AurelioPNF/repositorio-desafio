package teste9;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en","US"));
		Scanner input = new Scanner(System.in);
		
		int numCobaiasTeste = 0, totalCobaias = 0, numRato= 0 , numCoelho = 0 , numSapo = 0;
		char tipoCobaia;
		
		
		int quantidade = input.nextInt();
		for(int i=0;i<quantidade;i++) {
			numCobaiasTeste = input.nextInt();
			tipoCobaia = input.next().charAt(0);
			totalCobaias += numCobaiasTeste;
			if(tipoCobaia == 'C') {
				numCoelho += numCobaiasTeste;
			}else if(tipoCobaia == 'R') {
				numRato += numCobaiasTeste;
			}else if(tipoCobaia == 'S') {
				numSapo += numCobaiasTeste;
			}
		}
		
		double percentCoelho, percentRato, percentSapo;
		
		percentCoelho = (Double.valueOf(numCoelho)/Double.valueOf(totalCobaias))*100;
		percentRato = (Double.valueOf(numRato)/Double.valueOf(totalCobaias))*100;
		percentSapo = (Double.valueOf(numSapo)/Double.valueOf(totalCobaias))*100;
		/*Total: 92 cobaias
		Total de coelhos: 29
		Total de ratos: 40
		Total de sapos: 23
		Percentual de coelhos: 31.52 %
		Percentual de ratos: 43.48 %
		Percentual de sapos: 25.00 %*/
		
		System.out.println(String.format("Total: %d cobaias\nTotal de coelhos: %d\nTotal de ratos: %d\nTotal de sapos: %d", totalCobaias,numCoelho,numRato,numSapo));
		System.out.println(String.format("Percentual de coelhos: %.2f %%\nPercentual de ratos: %.2f %%\nPercentual de sapos: %.2f %%", percentCoelho,percentRato,percentSapo));

	}
}

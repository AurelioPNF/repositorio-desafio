package teste10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
 
public class TabuleiroSecreto {
    public static void main(String[] args) throws IOException {
    	Locale.setDefault(new Locale("en","US"));
    	Scanner scan = new Scanner(System.in);
    	int tamanho, qtdOperacoes, tipoOperacao;
    	int R = 0, pos = 0;
        
        tamanho = scan.nextInt();
        Integer[][] matriz = new Integer[tamanho][tamanho];
        qtdOperacoes = scan.nextInt();
        
        for(int i = 0; i<tamanho;i++) {
        	for(int j = 0; j<tamanho;j++) {
        		matriz[i][j] = 0;
        	}
        }
        
        for(int i=0;i<qtdOperacoes;i++) {
        	tipoOperacao = scan.nextInt();
        	pos = scan.nextInt();
        	switch(tipoOperacao) {
        		case 1:
        			R = scan.nextInt();
        			matriz = setLinha(matriz, pos, R);
        			break;
        		case 2:
        			R = scan.nextInt();
        			matriz = setColuna(matriz, pos, R);
        			break;
        		case 3:checaLinha(matriz,pos);break;
        		case 4:checaColuna(matriz,pos);break;
        	}
        }
        scan.close();
    }
    
    //Okay de velocidade
    private static Integer[][] setLinha(Integer[][] matriz,int posMudar, int R) {
    	for(int i = 0; i<matriz[0].length;i++) {
    		matriz[posMudar-1][i] = R;
        }
    	return matriz;
    }
    private static void checaLinha(Integer[][] matriz,int posChecar) {
    	Integer[] a = new Integer[matriz[0].length];
    	for(int i = 0; i<matriz[0].length;i++) {
    		a[i]= matriz[posChecar-1][i];
    	}
    	System.out.println(maisComum(a));
    }
    private static void checaColuna(Integer[][] matriz,int posChecar) {
    	Integer[] a = new Integer[matriz[0].length];
    	for(int i = 0; i<matriz[0].length;i++) {
    		a[i]= matriz[i][posChecar-1];
    	}
    	System.out.println(maisComum(a));
    }
    private static Integer[][] setColuna(Integer[][] matriz,int posMudar, int R) {
    	for(int i = 0; i<matriz[0].length;i++) {
    		matriz[i][posMudar-1] = R;
    	}
    	return matriz;
    }
    //
    
    private static int maisComum(Integer[] a) {
		ArrayList<Integer> quantidadeRepetidos = new ArrayList<Integer>(0);
		List<Integer> repetidos = Arrays.asList(a).stream().distinct().collect(Collectors.toList());
		
		int contador = 0;
		for(int i=0; i<repetidos.size();i++) {
			for(int j=0;j<a.length;j++) {
				if(repetidos.get(i)== a[j]) {
					contador++;
				}
			}
			quantidadeRepetidos.add(contador);
			contador = 0;
		}
		
		int maior = 0;
		int maiorNumero = 0;
		
		maior = Collections.max(quantidadeRepetidos);
		for(int i=0;i<quantidadeRepetidos.size();i++) {
			if(quantidadeRepetidos.get(i) == maior) {
				if(maiorNumero < repetidos.get(i)) {
					maiorNumero = repetidos.get(i);
				}
			}
		}
		return maiorNumero;
	}

}

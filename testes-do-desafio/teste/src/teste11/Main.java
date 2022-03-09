package teste11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Integer[] a = {1,1,2,2,3,3,3,3,3,3,4,4,4,4};
		List<Integer> list = Arrays.asList(1,1,2,3,3,3,3,4,4,4,4);
		//List<Integer> lista = new ArrayList(Arrays.asList(1,1,2,2,2,2,2,3,3,3,3,4,4,4,4));
		/*Integer[][] matriz = new Integer[5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				matriz[i][j] = i;
			}
		}
		checaLinha(matriz,1);
		//pegaMaior(lista);
		*/
		maisComum(a);
		
		//System.out.println(maiorNumero(a));
		//System.out.println(mostCommon(list));
	}
	
	private static int maiorNumero(int[] a) {
		int retem= a[0]-1;
		ArrayList<Integer> repetidos = new ArrayList<Integer>(0);
		ArrayList<Integer> quantidadeRepetidos = new ArrayList<Integer>(0);
		for(int i=1;i<a.length;i++) {
			if(retem!= a[i]) {
				repetidos.add(a[i]);
				retem = a[i];
			}
		}
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
		for(int i=0;i<repetidos.size();i++) {
			//Primeiro pegar o maior numero de repetições
			for(int j=0;j<quantidadeRepetidos.size();j++) {
				if(quantidadeRepetidos.get(j)>quantidadeRepetidos.get(maior)) {
					maior = j;
				}else if(quantidadeRepetidos.get(j)==quantidadeRepetidos.get(maior)) {
					if(repetidos.get(j)>repetidos.get(maior)){
						maiorNumero = repetidos.get(j);
					}else {
						maiorNumero = repetidos.get(maior);
					}
				}
			}
			//
			
		}
		return maiorNumero;
	}
	
	public static <T> T mostCommon(List<T> list) {
	    Map<T, Integer> map = new HashMap<>();

	    for (T t : list) {
	        Integer val = map.get(t);
	        map.put(t, val == null ? 1 : val + 1);
	    }

	    Entry<T, Integer> max = null;

	    for (Entry<T, Integer> e : map.entrySet()) {
	        if (max == null || e.getValue() > max.getValue()) {
	            max = e;
	            System.out.println(e);
	        }
	    }
	    System.out.println(map);
	    return max.getKey();
	}

	private static void pegaMaior(List<Integer> list) {
		System.out.println(list);
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i<list.size();i++) {
			map.put(i, list.get(i));
		}
		System.out.println(map);
	}

	
	private static void checaLinha(Integer[][] matriz,int posChecar) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i = 1; i<=matriz.length;i++) {
			for(int j = 1; j<=matriz.length;j++) {
				map.put(i, matriz[i-1][j-1]);
				
			}
		}
		System.out.println(map);
    	
    }
	
	private static int maisComum(Integer[] a) {
		ArrayList<Integer> quantidadeRepetidos = new ArrayList<Integer>(0);
		List<Integer> repetidos = Arrays.asList(a).stream().distinct().collect(Collectors.toList());
		
		System.out.println(repetidos);
		
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
		System.out.println(maiorNumero);
		return maiorNumero;
	}
}

package teste8;

public class DIO {

	public static void main(String[] args) {
		for(int i=0; i<12;i++) {
			for(int j=0; j<12;j++) {
				if(!(j+i == 11 || (j+i)%2 == 0 && j==i) && (i>=1 && j>=7 && i+j>=12 && i<j)) {
					System.out.print("x" + " ");
				}else {
					System.out.print(" "+" ");
				}
			}
			System.out.println();
		}
	}

}

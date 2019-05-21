
public class BinarySearch {
	
	public static int binarySearch(int valor, int[] valores) {
		int min=0,
			max=valores.length-1,
			avg;
		
		
		
		while(min<=max) {
			avg=(max+min)/2;
			if(valores[avg]==valor) {
				return avg;
			}
			else if(valor<valores[avg]) {
				max = avg-1;
			}
			else {
				min = avg+1;
			}
			
		}
		
		return -1;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] valores = {1,2,3,4,5,6,7,8,9,10};
		int[] valoresD = {13,24,36,49,51,60,71,84,93,101,120};
		int valor = 13;
		
		System.out.println(valoresD[binarySearch(valor, valoresD)]);
		
	}

}

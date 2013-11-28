import java.util.Random;
import java.lang.Math;
import java.util.Arrays;
class Soma2{
	private static int soma2(int[] A , int[] B){
		int contador = 0;
		for (int i = 0; i < A.length; i++){
			for (int j = 0; j < B.length; j++){
				if(A[i]+B[j] == 0 ){
					contador++;
				}
			}
		}
	return contador;	
	}

	private static int soma2Binaria(int[] A , int[] B){
		int contador = 0;	
		for (int i = 0; i < A.length; i++){
			if(buscaBinaria(B,-A[i],0 , A.length - 1)){
				contador ++;
			}
		}	
		return contador;	
	}

	private static boolean buscaBinaria(int [] A, int n , int inicio , int fim){
		int meio = (inicio + fim )/2;
		if(inicio > fim) return false;
		if(n > A[meio])
			return buscaBinaria(A,n, meio+1, fim);
		else if(n < A[meio])
			return buscaBinaria(A,n ,inicio, meio-1);
		return true;
	} 	

	public static int[] geraArray(int tamanho){
		Random r = new Random();
		int pow = 0;
		int[] result = new int[tamanho];
		for(int i = 0 ; i < result.length ; i ++){
			result[i] = r.nextInt(100000);
			pow = r.nextInt(3);
			result[i] *= Math.pow(-1.0, (double) pow);
		}
		Arrays.sort(result);
		return result;
	}
	public static void imprimeArray(int[] A){
		System.out.print('[');
		for(int i = 0 ; i < A.length - 1 ; i++){
			System.out.print(A[i]+",");
		}
		System.out.println(A[A.length - 1] + "]");
	}
	public static long tempoMedio(int[] A , int[] B){
		long somaTotal = 0 ; 
		long antes, depois;
		for(int a = 50; a != 0 ; a--){
			antes = System.nanoTime();
			soma2(A,B);
			depois = System.nanoTime();
			somaTotal += depois - antes;
		}
		return somaTotal/50;
	}
	public static long tempoMedioBinaria(int[] A , int[] B){
		long somaTotal = 0 ; 
		long antes, depois;
		for(int a = 50; a != 0 ; a--){
			antes = System.nanoTime();
			soma2Binaria(A,B);
			depois = System.nanoTime();
			somaTotal += depois - antes;
		}
		return somaTotal/50;
	}
	
	public static void main(String[] args){
		int tamanhoA = Integer.parseInt(args[0]);
		int tamanhoB = Integer.parseInt(args[1]);
		int[] A = geraArray(tamanhoA);
		int[] B = geraArray(tamanhoB);
		System.out.println(tempoMedio(A,B));
		System.out.println(tempoMedioBinaria(A,B));

	}
}
package zigzag;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		Puzzle game = new Puzzle();
		
		//Recogemos la información del ususario
		Boolean correctInput = game.getDataFromUser(scan);
		
		if(!correctInput){
			
			System.out.println("Entrada incorrecta."); //No se si es print o println, ver cuando pase los tests
		}
		else {
			
			//JUAMOS AL PUZZLE Y VEMOS LAS POSIBLES SOLUCIONES
			System.out.println("Entrada correcta.");
		}
		
		game.initializateArrays();
		
		scan.close();
		
//		/*COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS EN LA MATRIZ ARRAYDATA*/
//		int[][] arrayDataTest = game.getArrayData();
//		int dimension = arrayDataTest.length;
//		
//		for(int i=0; i<dimension; i++) {
//			
//			for(int j=0; j<dimension; j++) {
//				
//				System.out.print(arrayDataTest[i][j] + " ");
//			}
//			
//			System.out.print("\n");
//		}
//		/* FIN COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS EN LA MATRIZ ARRAYDATA*/
		
		/* COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS  EL ARRAYLIST*/
		System.out.println("\n---------------Comprobación arrayList---------------\n");
		
		ArrayList<int[]> tryArrayList = game.getArrayListData();
		int dimensionArrayList = tryArrayList.size();
		
		for(int i=0; i<dimensionArrayList; i++) {
			
			int[] arrayToPrint = tryArrayList.get(i);
			int lengthArrayToPrint = arrayToPrint.length;
			
			for(int j=0; j<lengthArrayToPrint; j++) {
				
				System.out.print(arrayToPrint[j] + " ");
			}
			
			System.out.print("\n");
		}
		/* FIN COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS EN EL ARRAYLIST*/
		
		/* COMPROBACIÓN DE QUE COJO BIEN LAS FILAS Y COLUMNAS COMO ATRIBUTOS DE CLASE*/
		System.out.println("\n---------------Comprobación filas y columnas ---------------\n");
		
		int rows = game.getRows();
		int columns = game.getColumns();
				
		System.out.println("Filas: " + rows + "  Columnas: " + columns);
		/* FIN COMPROBACIÓN DE QUE COJO BIEN LAS FILAS Y COLUMNAS COMO ATRIBUTOS DE CLASE*/
		
		/* COMPROBACIÓN DE QUE COJO BIEN LAS FILAS Y COLUMNAS COMO ATRIBUTOS DE CLASE*/
		System.out.println("\n---------------Comprobación maximo y minimo---------------\n");
		
		int min = game.getMin();
		int max = game.getMax();
				
		System.out.println("Maximo: " + max + "  Mínimo: " + min);
		/* FIN COMPROBACIÓN DE QUE COJO BIEN LAS FILAS Y COLUMNAS COMO ATRIBUTOS DE CLASE*/
		
		
		//COMPROBAR TODOS LOS ARRAYS 
	}
	
	
}

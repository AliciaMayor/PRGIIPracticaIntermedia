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
		
		/*IDEA: 
		 * · Si lo que pasamos por parametro a los metodos de encontrar solucion es la ultima posicion, hemos encontrado solucion
		 * · Si todos los metodos dan falso, backtracking
		 * · Si uno o varios metodos dan true, comprobar en el array posibles soluciones cual es la mayor lexicografica
		 * 		y esa es la posicion que pasaremos a los metodos en la siguiente pasada
		 * */
		boolean solution = game.checkUp(1, 1);
		System.out.print(solution);
		
		scan.close();
		

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
		
		
		/* COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS  EL ARRAYDATA*/
		System.out.println("\n---------------Comprobación arrayData---------------\n");
		
		int[][] arrayData = new int[rows][columns];
		arrayData = game.getArrayData();
		
		for(int z=0; z<rows; z++) {
			
			for(int x=0; x<columns; x++) {
				
				System.out.print(arrayData[z][x] + " ");
			}
			
			System.out.print("\n");
		}
		
		/* FIN COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS EN EL ARRAYDATA*/ 
		
		
		/* COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS  EL ARRAYDATABACKUP*/
		System.out.println("\n---------------Comprobación arrayDataBackUp---------------\n");
		
		int[][] arrayDataBackUp = new int[rows][columns];
		arrayDataBackUp = game.getArrayDataBackUp();
		
		for(int v=0; v<rows; v++) {
			
			for(int b=0; b<columns; b++) {
				
				System.out.print(arrayDataBackUp[v][b] + " ");
			}
			
			System.out.print("\n");
		}
		
		/* FIN COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS EN EL ARRAYDATABACKUP*/ 
		
		
		/* COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS  EL ARRAYDATAWITHSPACES*/
		System.out.println("\n---------------Comprobación arrayDataWithSpaces---------------\n");
		int rowsPlus = rows + (rows-1);
		int columnsPlus = columns + (columns-1);
		
		String[][] arrayDataWithSpaces = new String[rowsPlus][columnsPlus];
		arrayDataWithSpaces = game.getArrayDataWithSpaces();
		
		for(int p=0; p<rowsPlus; p++) {
			
			for(int o=0; o<columnsPlus; o++) {                                                                          
				
				System.out.print(arrayDataWithSpaces[p][o] + " ");
			}
			
			System.out.print("\n");
		}
		
		/* FIN COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS EN EL ARRAYDATAWITHSPACES*/ 
		
		
		/* COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS  EL ARRAYPOSIBLESOLUTIONS*/
		System.out.println("\n---------------Comprobación arayPosibleSolutions---------------\n");
		
		int[][] arrayPosibleSolutions =  new int[8][2];
		arrayPosibleSolutions = game.getArrayPosibleSolutions();
		
		for(int f=0; f<8; f++) {
			
			for(int d=0; d<2; d++) {
				
				System.out.print(arrayPosibleSolutions[f][d] + " ");
			}
			
			System.out.print("\n");
		}
		
		/* FIN COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS EN EL ARRAYPOSIBLESOLUTIONS*/ 
	}
	
	
}

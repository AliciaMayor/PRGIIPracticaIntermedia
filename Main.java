package zigzag;

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
		
		scan.close();
		
		/*COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS EN LA MATRIZ ARRAYDATA*/
		int[][] arrayDataTest = game.getArrayData();
		int dimension = arrayDataTest.length;
		
		for(int i=0; i<dimension; i++) {
			
			for(int j=0; j<dimension; j++) {
				
				System.out.print(arrayDataTest[i][j] + " ");
			}
			
			System.out.print("\n");
		}
		/* FIN COMPROBACIÓN DE QUE ESTOY GUARDANDO BIEN LOS DATOS EN LA MATRIZ ARRAYDATA*/
	}
	
	
}

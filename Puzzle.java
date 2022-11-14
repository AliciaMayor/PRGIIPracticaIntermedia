package zigzag;

import java.util.ArrayList;
import java.util.Scanner;

/**
*
* @author Alicia Mayor
*/

public class Puzzle {
		
	private int[][] arrayData;
	
	/**
	* Getter
	* @return arrayDate: the array where the input data is saved
	*/
	public int[][] getArrayData() {
		
		return this.arrayData;
	}
	
	/**
	* Method that fills arrayPieces with the information about the pieces
	* @Param Scanner scan, the scan with which the input is collected
	* @Return boolean, true in case that the data is correct and false in case it is incorrect (The game can not be played then)
	*/
	public boolean getDataFromUser(Scanner scan) {
		
		//Coger la primera fila que mete el usuario
		String firstLine = scan.nextLine();
		
		//Ver si no tiene un espacio al principio y al final
		int numberCaractersString = firstLine.length();
		if(firstLine.charAt(0)==' ') {
			
			return false;
		}
		if(firstLine.charAt(numberCaractersString-1)==' ') {
			
			return false;
		}
		
		//Si la entrada de la primera linea es correcta, hacer split y contar cuantos numeros ha metido (numbersPerRow)
		String[] numbersOfRow = firstLine.split(" ");
		
		//Calculamos la dimensión de la matriz que coge los datos ya que sabemos cuantos numeros hay en la linea
		int dimension = numbersOfRow.length;
		
//		arrayData = new int[dimension][dimension];
//		int[][] prueba = new int[numbersPerRow][numbersPerRow];
		
		//Rellenamos la primera fila del array de Datos con la primera fila introducida por el usuario
		for(int i=0; i<dimension; i++) {
			
			arrayData[0][i] = Integer.parseInt(numbersOfRow[i]);
		}
		
		int numLine = 1;
		
		//Rellenamos el resto de filas de la matriz, desde la segunda ya que la primera ya está cubierta
		while(scan.hasNextLine()) { //Para parar la entrada hacer ctrl+d
			
			String line = scan.nextLine(); //Cogemos la linea que introduce el usuario
			
			//Ver si no tiene espacios al principio o al final del String
			if(line.charAt(0)==' ') {
				
				return false;
			}
			if(line.charAt(numberCaractersString-1)==' ') {
				
				return false;
			}
			
			String[] numbersOfRows = line.split(" ");
			
			//Rellenamos la fila correspondiente de la matriz de datos con los numeros de la linea introducida
			for(int k=0; k<dimension; k++) {
				
				arrayData[numLine][k] = Integer.parseInt(numbersOfRows[k]);
			}
			
			numLine++;
		}
		
		return true;
	}
}

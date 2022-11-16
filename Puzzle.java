package zigzag;

import java.util.ArrayList;
import java.util.Scanner;

/**
*
* @author Alicia Mayor
*/

public class Puzzle {
		
	private ArrayList<int[]> arrayListData = new ArrayList<int[]>();
	
	/**
	* Getter
	* @return arrayListData: the arrayList where the input data is saved
	*/
	public ArrayList<int[]> getArrayListData() {
		
		return this.arrayListData;
	}
	
	/**
	* Method that fills arrayListData with the informattion that the user inserts
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
		
		//Creamos array de esa longitud para meter la primera fila en forma de array en la primera posicion del arrayList
		int[] arrayFirstRow = new int[dimension];
		
		//Rellenamos el primer array del ArrayList con los datos de la primera fila
		for(int i=0; i<dimension; i++) {
			
			arrayFirstRow[i] = Integer.parseInt(numbersOfRow[i]);
		}
		
		arrayListData.add(arrayFirstRow);
		
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
			
			int[] arrayRow = new int[dimension];
			
			//Rellenamos el array correspondiente a la linea de la matriz que se está introduciendo
			for(int k=0; k<dimension; k++) {
				
				arrayRow[k] = Integer.parseInt(numbersOfRows[k]);
			}
			
			arrayListData.add(arrayRow);
			
		}
		
		return true;
	}
}

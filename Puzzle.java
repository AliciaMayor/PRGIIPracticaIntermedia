package zigzag;

import java.util.ArrayList;
import java.util.Scanner;

/**
*
* @author Alicia Mayor
*/

public class Puzzle {
		
	private ArrayList<int[]> arrayListData = new ArrayList<int[]>();
	private int rows = 0; //numero de filas que introduce el usuario
	private int columns = 0; //numero de columnas que introduce el usuario
	private int[][] arrayData; //datos que introduce el usuario en formato array
	private String[][] arrayDataWithSpaces; //datos que introduce el usuario en formato array pero con espacios para dibujar las lineas
	private int[][] arrayDataBackUp; //datos que introduce el usuario en formato array para backup en el backtrackin
	int min = 10; //numero minimo introducido por el usuario
	int max = 0;; //numero maximo introducido por el usuario
	
	/**
	* Getter
	* @return arrayListData: the arrayList where the input data is saved
	*/
	public ArrayList<int[]> getArrayListData() {
		
		return this.arrayListData;
	}
	
	/**
	* Getter
	* @return min: the minimum number inserted by the user
	*/
	public int getMin() {
		
		return this.min;
	}
	
	/**
	* Setter
	* @param min: the minimum number inserted by the user
	*/
	public void setMin(int min) {
		
		this.min = min;
	}
	
	/**
	* Getter
	* @return max: the maximum number inserted by the user
	*/
	public int getMax() {
		
		return this.max;
	}
	
	/**
	* Setter
	* @param max: the maximum number inserted by the user
	*/
	public void setMax(int max) {
		
		this.max = max;
	}
	
	/**
	* Getter
	* @return rows: the number of rows introduced by the user
	*/
	public int getRows() {
		
		return this.rows;
	}
	
	/**
	* Setter
	* @param rows: the number of rows introduced by the user
	*/
	public void setRows(int rows) {
		
		this.rows = rows;
	}
	
	/**
	* Getter
	* @return columns: the number of columns introduced by the user
	*/
	public int getColumns() {
		
		return this.columns;
	}
	
	/**
	* Setter
	* @param columns: the number of columns introduced by the user
	*/
	public void setColumns(int columns) {
		
		this.columns = columns;
	}
	
	/**
	* Method that fills arrayListData with the informattion that the user inserts
	* @param Scanner scan, the scan with which the input is collected
	* @return boolean, true in case that the data is correct and false in case it is incorrect (The game can not be played then)
	*/
	public boolean getDataFromUser(Scanner scan) {
		
		int rowNumber = 1;
		
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
		this.setColumns(dimension); //Atributo de clase que representa el numero de columnas
		
		//Creamos array de esa longitud para meter la primera fila en forma de array en la primera posicion del arrayList
		int[] arrayFirstRow = new int[dimension];
		
		//Rellenamos el primer array del ArrayList con los datos de la primera fila
		for(int i=0; i<dimension; i++) {
			
			if(!isAnumber(numbersOfRow[i])) {
				
				return false;
			}
			
			//Si el numero es menor que el minimo atributo de clase, se sustituye
			if(Integer.parseInt(numbersOfRow[i])<this.min) {
				
				this.setMin(Integer.parseInt(numbersOfRow[i]));
			}
			
			//Si el numero es mayor que el maximo atributo de clase, se sustituye
			if(Integer.parseInt(numbersOfRow[i])>this.max) {
				
				this.setMax(Integer.parseInt(numbersOfRow[i]));
			}
			
			arrayFirstRow[i] = Integer.parseInt(numbersOfRow[i]);
		}
		
		arrayListData.add(arrayFirstRow);
		
		//Rellenamos el resto de filas de la matriz, desde la segunda ya que la primera ya está cubierta
		while(scan.hasNextLine()) { //Para parar la entrada hacer ctrl+d
			
			rowNumber++;
			
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
				
				if(!isAnumber(numbersOfRows[k])) {
					
					return false;
				}
				
				//Si el numero es menor que el minimo atributo de clase, se sustituye
				if(Integer.parseInt(numbersOfRows[k])<this.min) {
					
					this.setMin(Integer.parseInt(numbersOfRows[k]));
				}
				
				//Si el numero es mayor que el maximo atributo de clase, se sustituye
				if(Integer.parseInt(numbersOfRows[k])>this.max) {
					
					this.setMax(Integer.parseInt(numbersOfRows[k]));
				}
				
				arrayRow[k] = Integer.parseInt(numbersOfRows[k]);
			}
			
			arrayListData.add(arrayRow);
			
		}
		
		this.setRows(rowNumber);
		return true;
	}
	
	/**
	* Method that chekcs if a value is valid (number between 1 and 9)
	* @param number, the number that is wanted to be checked
	* @return boolean, true in case that the number is valid and false in case it is invalid
	*/
	public boolean isAnumber(String number) {
		
		boolean isNumber = false;
		String posibilities = "123456789";
		
		for(int i=0; i<posibilities.length(); i++) {
			
			if(number.charAt(0) ==posibilities.charAt(i)) {
				
				isNumber = true;
			}
		}
		
		return isNumber;
	}
	
	/**
	* Method that fills the matrix attributes of class that represents the data in matrix form
	*/
	public void initializateArrays() {
		
		int nArrayList = 0;
		int mArrayList = 0;
		this.arrayData = new int[this.rows][this.columns];
		this.arrayDataBackUp = new int[this.rows][this.columns];
		this.arrayDataWithSpaces = new String[this.rows + (this.rows - 1)][this.columns + (this.columns - 1)];
		
		for(int i=0; i<this.rows; i++) {
			
			for(int j=0; j<this.columns; j++) {
				
				this.arrayData[i][j] = this.arrayListData.get(i)[j];
				this.arrayDataBackUp[i][j] = this.arrayListData.get(i)[j];
			}
		}
		
		for(int m=0; m<(this.rows + (this.rows - 1)); m=+2) {
			
			for(int n=0; n<(this.columns + (this.columns - 1)); n=+2) {
				
				this.arrayDataWithSpaces[m][n]=  String.valueOf(this.arrayListData.get(mArrayList)[nArrayList]);
				nArrayList++;		
			}
			
			nArrayList = 0;
			mArrayList++;
		}
	}
}

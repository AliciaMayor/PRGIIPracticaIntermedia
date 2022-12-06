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
	private int[][] posibleSolutions = new int[8][2]; //Array que guarda las posibles posiciones solucion
	/* FORMA DEL ARRAY DE POSIBLESSOLUCIONES: 
	 *   [i][j]  Arriba
	 *   [i][j]  Abajo
	 *   [i][j]  Derecha
	 *   [i][j]  Izquierda
	 *   [i][j]  Arriba-Derecha
	 *   [i][j]  Arriba-Izquierda
	 *   [i][j]  Abajo-Derecha
	 *   [i][j]  Abajo-Izquierda
	 */  
	
	/**
	* Getter
	* @return arrayListData: the arrayList where the input data is saved
	*/
	public ArrayList<int[]> getArrayListData() {
		
		return this.arrayListData;
	}
	
	/**
	* Getter
	* @return arrayData: the array where the input data is saved
	*/
	public int[][] getArrayData() {
		
		return this.arrayData;
	}
	
	/**
	* Getter
	* @return arrayDataBackUp: the backup array where the input data is saved
	*/
	public int[][] getArrayDataBackUp() {
		
		return this.arrayDataBackUp;
	}
	
	/**
	* Getter
	* @return arrayDataWithSpaces: the backup array where the input data is saved + spaces to draw the lines
	*/
	public String[][] getArrayDataWithSpaces() {
		
		return this.arrayDataWithSpaces;
	}
	
	/**
	* Getter
	* @return arrayPosibleSolutions: the backup array with the posible solutions
	*/
	public int[][] getArrayPosibleSolutions() {
		
		return this.posibleSolutions;
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
		int rowsAmplified = this.rows + (this.rows - 1);
		int columnsAmplified = this.columns + (this.columns - 1);
		this.arrayDataWithSpaces = new String[rowsAmplified][columnsAmplified];
		
		for(int i=0; i<this.rows; i++) {
			
			for(int j=0; j<this.columns; j++) {
				
				this.arrayData[i][j] = this.arrayListData.get(i)[j];
				this.arrayDataBackUp[i][j] = this.arrayListData.get(i)[j];
			}
		}
		
		for(int m=0; m<rowsAmplified; m=m+2) {
			
			for(int n=0; n<columnsAmplified; n=n+2) {
				
				this.arrayDataWithSpaces[m][n]=  String.valueOf(this.arrayListData.get(mArrayList)[nArrayList]);
				nArrayList++;		
			}
			
			nArrayList = 0;
			mArrayList++;
		}
		
		for(int o=0; o<rowsAmplified; o++) {
			
			for(int p=0; p<columnsAmplified; p++) {
				
				if(this.arrayDataWithSpaces[o][p]==null) {
					
					this.arrayDataWithSpaces[o][p] = " ";
				}
			}
		}
		
		//La matriz de pposibles soluciones la inicializamos a -1, ya que es un valor que no es posible en la matriz 
		for(int h=0; h<8; h++) {
			
			for(int g=0; g<2; g++) {
				
				this.posibleSolutions[h][g] = -1;
			}
		}
	}
	
	/**
	* Method that chekcs if a posible solution is to go up
	* @param i, row in which we are situated
	* @param j, column in which we are situated
	* @return boolean, true if it is a posible solution, false in casi it is not
	*/
	public boolean checkUp(int i, int j) {
		
		boolean posibleSolution =  false;
		int numberActualPosition = this.arrayData[i][j];
		
		//Para i=0 no podemos ir hacia arriba porque se sale fuera de los bordes del array
		if(i!=0) {
			
			//Guardamos el numero que hay en la posicion de arriba
			int numberUp = this.arrayData[i-1][j];
			
			//Si la posicion actual es el numero maximo del array, hay que buscar que el siguiente sea el minimo
			if(numberActualPosition == this.max) {
				
				//Chequeamos que la posicion a la que vamos no sea 0, ya que eso indicaria que ya hemos pasado por ahi
				if((numberUp== this.min) && (numberUp!=0)) {
					
					posibleSolution = true;
					
					//Guardamos la posible solución para al tener todas calculadas elegir la que es mayor lexicograficamente
					this.posibleSolutions[0][0] = i-1;
					this.posibleSolutions[0][1] = j;
					
					this.arrayData[i][j]=0; //Si es solucion ponemos a 0 la posicion actual para no volver a ella
				}
			}
			//Sino, nos basta con que sea una unidad más que el actual
			else {
				
				if((numberUp == numberActualPosition+1) && (numberUp!=0)) {
					
					posibleSolution = true;
					
					this.posibleSolutions[0][0] = i-1;
					this.posibleSolutions[0][1] = j;
					
					this.arrayData[i][j]=0;
				}
			}
		}
		
		return posibleSolution;
	}	
	
	
}




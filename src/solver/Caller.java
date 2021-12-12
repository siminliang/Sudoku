package solver;

import java.util.Arrays;

public class Caller {
	public int myNumber;
	public Caller(int myNumber) {
		this.myNumber = myNumber;
	}
	public void setNumber() {
		myNumber = 10;
	}
	public int getNumber() {
		return myNumber;
	}
	
	public static void main(String[] args) {
		//this is grid user will be working with
		int[][] mygrid =  { 
				 {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		         {0, 0, 5, 2, 0, 6, 3, 0, 0} };
		         
		SudokuSolver ss = new SudokuSolver(mygrid);
		ss.solve();
		//ss.PrintUnfilledGrid();
		ss.printSolution();
		System.out.println();
		ss.PringOriginal();
		

		System.out.println(mygrid[8][8]);
		ss.solve(8, 8);
		System.out.println(mygrid[8][8]);
		ss.PringOriginal();
	}
}
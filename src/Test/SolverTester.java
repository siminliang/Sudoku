package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import solver.SudokuSolver;

class SolverTester {
	int[][] grid = { 
			 {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
	         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
	         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
	         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
	         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
	         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
	         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
	         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
	         {0, 0, 5, 2, 0, 6, 3, 0, 0} };
	SudokuSolver ss= new SudokuSolver(grid);
	
	@Test
	void test() {
		//repeat horz same square
		assertEquals(ss.possibleSquare(1, 0, 6), false);
		//repeat horz diff square
		assertEquals(ss.possibleSquare(8, 0, 5), false);
		//repeat vert same square
		assertEquals(ss.possibleSquare(2, 5, 3), false);
		//repeat vert diff square
		assertEquals(ss.possibleSquare(8, 0, 9), false);
		//valid horz vert repeat square
		assertEquals(ss.possibleSquare(2, 4, 8), false);
		
		//valid number
		assertEquals(ss.possibleSquare(8, 4, 8), true);
		
	}

}

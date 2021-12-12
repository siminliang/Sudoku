package solver;

import java.util.Arrays;

public class SudokuSolver {
	public int[][] grid = new int[9][9];
	public int[][] original;
	boolean solved = true;
	public String myStr = "empty";
	
	public SudokuSolver(int[][]mygrid) {
		
		original = mygrid.clone();
		for(int i = 0; i< grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				this.grid[i][j] = mygrid[i][j];
			}
		}
		solve();
	}
		
	//check if square is possible
	public boolean possibleSquare(int row, int col,int n){
    	for(int i = 0; i< this.grid.length; i++) {
    		if(this.grid[i][col] == n && i!=row )
    			return false;
    		if(this.grid[row][i] == n && i!=col )
    			return false;
    	}
        int row0 = row/3*3;
        int col0 = col/3*3;
        for(int i = 0 ; i<3; i++){
            for(int j = 0; j< 3; j++){
                if(this.grid[row0+i][col0+j] == n && (row0+i != row && col0+j !=col))
                    return false;
            }
        }
    	return true;
    }
	
	//check if puzzle is valid
	public boolean valid() {
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(!possibleSquare(i, j, this.grid[i][j]))
					return false;
			}
		}
		return true;
	}
	
	//this solves the whole sudoku
	public void solve() {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				if(grid[row][col] == 0) {
					for(int n = 1; n < 10; n++) {
						if(this.possibleSquare(row, col, n)) {
							grid[row][col] = n;
							solve();
							if(valid()) {
								return;
							}
							else grid[row][col] = 0;
						}
					}
					return;
				}
			}
		}
	}
	
	//this solves a particular square
	public void solve(int x, int y) {
		original[x][y] = this.grid[x][y];
	}
		
	
	//prints whole solution;
	public String printSolution() {
		String s = "";
		for(int i = 0; i < 9; i++) {
			System.out.println(i + Arrays.toString(grid[i]));
			s += Arrays.toString(grid[i]) + "\n";
		}
		return s;
	}
	
	//prints original/ working set of sudoku
	public void PringOriginal() {
		for(int i = 0; i < 9; i++) {
			System.out.println(i + Arrays.toString(original[i]));
		}
	}
}

package ama01;

public class A045_GameOfLife {

	public static void main(String[] args) {
		
		int[][]grid = {
				  {0,1,0},
				  {0,0,1},
				  {1,1,1},
				  {0,0,0}
				  };
		
		gameOfLife2(grid);
		System.out.println("======");
//		print(grid);
	}
	
	
	public static void gameOfLife2(int[][] board) {
	    if (board == null || board.length == 0) return;
	    int m = board.length, n = board[0].length;

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            int lives = liveNeighbors(board, m, n, i, j);

	            // In the beginning, every 2nd bit is 0;
	            // So we only need to care about when will the 2nd bit become 1.
	            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
	                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
	            }
	            if (board[i][j] == 0 && lives == 3) {
	                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
	            }
	        }
	    }

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            board[i][j] >>= 1;  // Get the 2nd state.
	        }
	    }
	}

	public static int liveNeighbors(int[][] board, int m, int n, int i, int j) {
	    int lives = 0;
	    for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
	        for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
	        	
	            lives += board[x][y] & 1;
	            System.out.println("x: "+x+" y: "+y+"  "+"board[x][y]: "+ board[x][y]+" board[x][y] & 1: "+(board[x][y] & 1)+" lives: "+lives);
	        }
	    }
	    print(board);
	    lives -= board[i][j] & 1;
	    return lives;
	}
	
	
	
	
	static int[][] dir ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
	public static void gameOfLife(int[][] board) {
	    for(int i=0;i<board.length;i++){
	        for(int j=0;j<board[0].length;j++){
	            int live=0;
	        	System.out.println("i: "+i+" j: "+j);
	            for(int[] d:dir){
	                if(d[0]+i<0 || d[0]+i>=board.length || d[1]+j<0 || d[1]+j>=board[0].length) continue;
	                if(board[d[0]+i][d[1]+j]==1 || board[d[0]+i][d[1]+j]==2) live++;
	            }
	            if(board[i][j]==0 && live==3) board[i][j]=3;
	            if(board[i][j]==1 && (live<2 || live>3)) board[i][j]=2;
	        }
	    }
	    System.out.println("================");
	    print(board);
	    for(int i=0;i<board.length;i++){
	        for(int j=0;j<board[0].length;j++){
	            board[i][j] %=2;
	        }
	    }
	}
	
	
	
	
	public static void print(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		for(int i =0; i< m; i++) {
			for(int j=0 ; j<n; j++) {
				System.out.print(grid[i][j]);
			}
		System.out.println();
		}
	}
	
	
}

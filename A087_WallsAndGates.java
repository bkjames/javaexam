package ama01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A087_WallsAndGates {
	
	public static void main(String[] args) {
		int INF = Integer.MAX_VALUE;
		int[][] rooms = {
				{INF, -1, 0, INF},
				{INF, INF, INF, -1},
				{INF, -1, INF, -1},
				{0,1, INF, INF}
		};
		new A087_WallsAndGates().wallsAndGates(rooms);
		
		for(int row=0; row<rooms.length; row++) {
			for( int col=0; col< rooms[0].length; col++) {
				System.out.print(rooms[row][col]+" ");
			}
			System.out.println();
		}
	}
	
	public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();   //level traversal, make sure get the shortest distance
            for(int s = 0; s < size; s++){
                int[] top = queue.poll();
                int row = top[0], col = top[1];
                for(int[] dir : directions){
                    int newX = row + dir[0], newY = col + dir[1];
                    if(newX < 0 || newX >= rooms.length || newY < 0 || newY >= rooms[0].length){
                        continue;
                    }
                    if(rooms[newX][newY] == Integer.MAX_VALUE){
                        rooms[newX][newY] = rooms[row][col] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }

	
	private static final int EMPTY = Integer.MAX_VALUE;
	private static final int GATE = 0;
	private static final List<int[]> DIRECTIONS = Arrays.asList(
	        new int[] { 1,  0},
	        new int[] {-1,  0},
	        new int[] { 0,  1},
	        new int[] { 0, -1}
	);

	public void wallsAndGates2(int[][] rooms) {
	    int m = rooms.length;
	    if (m == 0) return;
	    int n = rooms[0].length;
	    Queue<int[]> q = new LinkedList<>();
	    for (int row = 0; row < m; row++) {
	        for (int col = 0; col < n; col++) {
	            if (rooms[row][col] == GATE) {
	                q.add(new int[] { row, col });
	            }
	        }
	    }
	    while (!q.isEmpty()) {
	        int[] point = q.poll();
	        int row = point[0];
	        int col = point[1];
	        for (int[] direction : DIRECTIONS) {
	            int r = row + direction[0];
	            int c = col + direction[1];
	            if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
	                continue;
	            }
	            rooms[r][c] = rooms[row][col] + 1;
	            q.add(new int[] { r, c });
	        }
	    }
	}
}

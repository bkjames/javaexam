package ama01;

public class A064_ShortestDistance {

	
	public static void main(String[] args) {
		int[][Input =[[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
	}
	   public int shortestDistance(int[][] grid) {
	        if (grid == null || grid[0].length == 0) return 0;
	        final int[] shift = new int[] {0, 1, 0, -1, 0};
	        
	        int row  = grid.length, col = grid[0].length;
	        int[][] distance = new int[row][col];
	        int[][] reach = new int[row][col];
	        int buildingNum = 0;
	        
	        for (int i = 0; i < row; i++) {
	            for (int j =0; j < col; j++) {
	                if (grid[i][j] == 1) {
	                    buildingNum++;
	                    Queue<int[]> myQueue = new LinkedList<int[]>();
	                    myQueue.offer(new int[] {i,j});

	                    boolean[][] isVisited = new boolean[row][col];
	                    int level = 1;
	                    
	                    while (!myQueue.isEmpty()) {
	                        int qSize = myQueue.size();
	                        for (int q = 0; q < qSize; q++) {
	                            int[] curr = myQueue.poll();
	                            
	                            for (int k = 0; k < 4; k++) {
	                                int nextRow = curr[0] + shift[k];
	                                int nextCol = curr[1] + shift[k + 1];
	                                
	                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
	                                    && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
	                                        //The shortest distance from [nextRow][nextCol] to thic building
	                                        // is 'level'.
	                                        distance[nextRow][nextCol] += level;
	                                        reach[nextRow][nextCol]++;
	                                        
	                                        isVisited[nextRow][nextCol] = true;
	                                        myQueue.offer(new int[] {nextRow, nextCol});
	                                    }
	                            }
	                        }
	                        level++;
	                    }
	                }
	            }
	        }
	        
	        int shortest = Integer.MAX_VALUE;
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
	                    shortest = Math.min(shortest, distance[i][j]);
	                }
	            }
	        }
	        
	        return shortest == Integer.MAX_VALUE ? -1 : shortest;
	        
	        
	    }
	   
	  // java
	   int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

	   public int shortestDistance(int[][] grid) {
	       int m = grid.length, n = grid[0].length;
	       int[][] dist = new int[m][n];
	       // Initialize building list and accessibility matrix `grid`
	       List<Tuple> buildings = new ArrayList<>();
	       for (int i = 0; i < m; ++i)
	           for (int j = 0; j < n; ++j) {
	               if (grid[i][j] == 1)
	                   buildings.add(new Tuple(i, j, 0));
	               grid[i][j] = -grid[i][j];
	           }
	       // BFS from every building
	       for (int k = 0; k < buildings.size(); ++k)
	           bfs(buildings.get(k), k, dist, grid, m, n);
	       // Find the minimum distance
	       int ans = -1;
	       for (int i = 0; i < m; ++i)
	           for (int j = 0; j < n; ++j)
	               if (grid[i][j] == buildings.size() && (ans < 0 || dist[i][j] < ans))
	                   ans = dist[i][j];
	       return ans;
	   }

	   public void bfs(Tuple root, int k, int[][] dist, int[][] grid, int m, int n) {
	       Queue<Tuple> q = new ArrayDeque<>();
	       q.add(root);
	       while (!q.isEmpty()) {
	           Tuple b = q.poll();
	           dist[b.y][b.x] += b.dist;
	           for (int i = 0; i < 4; ++i) {
	               int x = b.x + dx[i], y = b.y + dy[i];
	               if (y >= 0 && x >= 0 && y < m && x < n && grid[y][x] == k) {
	                   grid[y][x] = k + 1;
	                   q.add(new Tuple(y, x, b.dist + 1));
	               }
	           }
	       }
	   }
	   class Tuple {
	       public int y;
	       public int x;
	       public int dist;

	       public Tuple(int y, int x, int dist) {
	           this.y = y;
	           this.x = x;
	           this.dist = dist;
	       }
	   }
}

package ama01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class A020_SnakesAndLadders {

	public static void main(String[] args) {
		int[][] board = {
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,35,-1,-1,13,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,15,-1,-1,-1,-1}
				};
		
		A020_SnakesAndLadders a = new A020_SnakesAndLadders();
		System.out.println(a.snakesAndLadders(board));
//		System.out.println(a.snakesAndLadders_change(board));
	}
	
	public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        for (int move = 0; !queue.isEmpty(); move++) {
            for (int size = queue.size(); size > 0; size--) {
                int num = queue.poll();
                if (visited[num]) continue;
                visited[num] = true;
                if (num == n * n) {
                	System.out.println("move: "+move);
                	return move;
                }
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i;
                    int value = getBoardValue(board, next);
                    if (value > 0) next = value;
                    if (!visited[next]) {
                    	System.out.println("visited["+next+"]"+" "+visited[next] );
                    	queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int oldRow = (num - 1) / n;
        int row = n-1 -oldRow;
        int oldCol = (num-1) % n;
        int col = oldRow % 2 == 0 ? oldCol : n - 1 - oldCol;
        System.out.println("board["+row+"]["+col+"] "+board[row][col]);
        System.out.println();
        return board[row][col];
    }
	
	public int snakesAndLadders_change(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int i = n - 1, j = 0, index = 0, inc = 1;
        while (index < n * n) {
            arr[index++] = board[i][j];
            System.out.println("board["+i+"]["+j+"] "+board[i][j]);
            if (inc == 1 && j == n - 1) {
                inc = -1;
                i--;
            } else if (inc == -1 && j == 0) {
                inc = 1;
                i--;
            } else {
                j += inc;
            }
        }
        boolean[] visited = new boolean[n * n];
        Queue<Integer> q = new LinkedList<>();
        int start = arr[0] > -1 ? arr[0] - 1 : 0;
        q.offer(start);
        visited[start] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == n * n - 1) {
                    return step;
                }
                for (int next = cur + 1; next <= Math.min(cur + 6, n * n - 1); next++) {
                    int dest = arr[next] > -1 ? arr[next] - 1 : next;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        q.offer(dest);
                    }
                }
            }
            step++;
        }
        return -1;
    }
	
	
	
    
    
    
//dfs
        int res = -1;
        public int snakesAndLadders_dfs(int[][] board) {
            int n = board.length;
            dfs(board, new LinkedList<Integer>(){{add(1);}}, new boolean[n * n + 1], 0, n);
            return res;
        }
        
        public void dfs(int[][] board, List<Integer> cur, boolean[] visited, int move, int n) {
            if(cur.isEmpty()) return;
            List<Integer> nextList = new LinkedList<>();
            for(int i : cur) {
                if(visited[i]) continue;
                visited[i] = true;
                if (i == n * n) {
                    res = move;
                    return;
                }
                for(int j = 1; j <= 6 && i + j <= n * n; ++j) {
                    int next = i + j;
                    int value = getBoardValue_dfs(board, next);
                    if(value > 0) next = value;
                    if(!visited[next]) nextList.add(next);
                }
            }
            dfs(board, nextList, visited, move + 1, n);
            return;
        }
         
        private int getBoardValue_dfs(int[][] board, int num) {
            int n = board.length;
            int r = (num - 1) / n;
            int x = n - 1 - r;
            int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
            return board[x][y];
        }
    
    
    
    
    
	
	
	    public int snakesAndLadders4(int[][] board) {
	        int N = board.length;

	        Map<Integer, Integer> dist = new HashMap();
	        dist.put(1, 0);

	        Queue<Integer> queue = new LinkedList();
	        queue.add(1);

	        while (!queue.isEmpty()) {
	            int s = queue.remove();
	            if (s == N*N) return dist.get(s);

	            for (int s2 = s+1; s2 <= Math.min(s+6, N*N); ++s2) {
	                int rc = get(s2, N);
	                int r = rc / N, c = rc % N;
	                int s2Final = board[r][c] == -1 ? s2 : board[r][c];
	                if (!dist.containsKey(s2Final)) {
	                    dist.put(s2Final, dist.get(s) + 1);
	                    queue.add(s2Final);
	                }
	            }
	        }
	        return -1;
	    }

	    public int get(int s, int N) {
	        // Given a square num s, return board coordinates (r, c) as r*N + c
	        int quot = (s-1) / N;
	        int rem = (s-1) % N;
	        int row = N - 1 - quot;
	        int col = row % 2 != N % 2 ? rem : N - 1 - rem;
	        return row * N + col;
	    }
	
	
	
	
	
	
	public int snakesAndLadders2(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        for (int move = 0; !queue.isEmpty(); move++) {
            for (int size = queue.size(); size > 0; size--) {
                int num = queue.poll();
                System.out.println("num: "+num);
                if (visited[num]) continue;
                visited[num] = true;
                if (num == n * n) return move;
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i;
                    int value = getBoardValue2(board, next);
                    if (value > 0) next = value;
                    if (!visited[next]) queue.offer(next);
                }
            }
        }
        return -1;
    }

    private int getBoardValue2(int[][] board, int num) {
        int n = board.length;
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
        return board[x][y];
    }
}

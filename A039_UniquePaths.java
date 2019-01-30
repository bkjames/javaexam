package ama01;

public class A039_UniquePaths {
	public static void main(String[] args) {
		int m =3;
		int n =2;
		System.out.println(uniquePaths(m, 2));
	}
	
	
   public static int uniquePaths2(int m, int n) {
        int[][] d = new int[m][n];
        d[0][0]=1;
        
        for(int i=0; i<m;i++) {
        	for(int j=0; j<n; j++) {
        		if(i>0) d[i][j] += d[i-1][j];
        		if(j>0) d[i][j] += d[i][j-1];
        	}
        }
        return d[m-1][n-1];
    }
	   
	   

    public static int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
	

}

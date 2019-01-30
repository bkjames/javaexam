package ama01;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WordBreak aa = new WordBreak();
//		ArrayList<String> dict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
//		System.out.println(aa.wordBreak("catsandog", dict));
		
		List<String> dict = new ArrayList<>(Arrays.asList("leet", "codea"));
		System.out.println(aa.wordBreak("leetcodea", dict));
	}
	
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
        	System.out.println("start i: "+i);
            for (int j = 0; j < i; j++) {
            	System.out.println("j: "+j+" i: "+i+" "+(s.substring(j, i))+"  dp["+j+"]: "+dp[j]);
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    System.out.println("dp[i]: "+i+" "+dp[i]);
                    break;
                }
              	
            }
            System.out.println();
        }
        System.out.println("dp[s.length()]: "+dp[s.length()]+" "+s.length());
        return dp[s.length()];
    }
    
    
	public boolean wordBreak2(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0){
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }
        for(int i = 1; i <= s.length(); i++){
            String curr = s.substring(0, i);
            if(set.contains(curr)){
                dp[i] = true;
            }else{
                for(int j = i - 1; j >= 0; j--){
                    if(dp[j] && set.contains(s.substring(j, i))){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
	
	
	public boolean wordBreak(String s, Set<String> dict) {
		  if (s == null || s.length() == 0) return false;
		  
		  int n = s.length();
		  
		  // dp[i] represents whether s[0...i] can be formed by dict
		  boolean[] dp = new boolean[n];
		  
		  for (int i = 0; i < n; i++) {
		    for (int j = 0; j <= i; j++) {
		      String sub = s.substring(j, i + 1);
		      
		      if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
		        dp[i] = true;
		        break;
		      }
		    }
		  }
		  
		  return dp[n - 1];
		}
}

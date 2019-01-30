package ama01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A034_LetterCombinations {

	public static void main(String[] args) {
		String str = "23";
		List<String> val = letterCombinations2(str);
		
		for(int i=0; i<val.size(); i++) {
			System.out.println(val.get(i));
		}
		
	}
	
	
	 public static List<String> letterCombinations2(String digits) {
         String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
         List<String> result = new ArrayList<String>();
 
         if (digits.length()==0) return result;
         
         result.add("");
         for (int i=0; i<digits.length(); i++) {
        	 System.out.println(digitletter[digits.charAt(i)-'0']);
             result = combine(digitletter[digits.charAt(i)-'0'],result);
         }
         
         return result;
     }
     
     public static List<String> combine(String digit, List<String> l) {
         List<String> result = new ArrayList<String>();
         
         for (int i=0; i<digit.length(); i++) 
             for (String x : l) {
            	 System.out.println("x: "+x);
                 result.add(x+digit.charAt(i));
             }
 
         return result;
     }
	
     
	
	
	public static List<String> letterCombinations3(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
			}
		}
		return ans;
	}
	
	
	
	 
	
	
//	public static List<String> letterCombinations(String digits) {
//        List<String> list = new LinkedList<>();
//        if(digits == null || digits.length() == 0) return list;
//        char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
//        backtrack(digits,list,map,new StringBuilder(),0);
//        return list;
//    }
//	
//	
//	
//    private static void backtrack(String digits, List<String> list,char[][] map, StringBuilder sb, int start){
//        if(start == digits.length()) {
//            list.add(new String(sb));
//            return;
//        }
//        int num = digits.charAt(start) - '0';
//        for(int i = 0;i< map[num].length;i++){
//            sb.append(map[num][i]);
//            backtrack(digits,list,map,sb,start+1);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//    }
}

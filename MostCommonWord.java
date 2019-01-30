package ama01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		mostCommonWord(paragraph, banned);
	}
	public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int max = -1;
        String ans = "";
        paragraph += ".";
        
        for(String str : banned) {
            set.add(str);
        }
        
        for(int i = 0; i < paragraph.length(); i++) {
            char cur = paragraph.charAt(i);
            
            if((cur >= 'a' && cur <= 'z') || (cur >= 'A' && cur <= 'Z')) {
                sb.append(cur);
            }
            else if(sb.length() > 0) {
                String s = sb.toString().toLowerCase();
                if(!set.contains(s)) {
                   map.put(s, map.getOrDefault(s, 0) + 1);
                    if(map.get(s) > max) {
                        max = map.get(s);
                        ans = s;
                    }
                }
                sb = new StringBuilder();
            }
        }
        
        return ans;
    }
}

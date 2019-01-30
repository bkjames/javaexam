package ama01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CustomerLunchOptions02 {

	
	static class Pair implements Comparable<Pair>{
		String pairKey;
		String pairValue;
		
		Pair(String pairKey, String pairValue){
			this.pairKey = pairKey;
			this.pairValue = pairValue;
		}
		
		public String getPairKey() {
			return pairKey;
		}
		public String getPairValue() {
			return pairValue;
		}
		public String toString() {
			return getPairKey()+""+ getPairValue();
		}

		@Override
		public int compareTo(Pair pair) {
			// TODO Auto-generated method stub
			int compare = pairKey.compareTo(pair.getPairKey());
			if(compare ==0) {
				compare = pairValue.compareTo(pair.getPairValue());
			}
			return compare;
		}
	}
	
	public static void inputAndSet(List<Pair> lunchMenuPairs, List<Pair> teamCuisinePreferencePairs) {
		
		int lunchMenuPairCount = -1;
		int teamCuisinePreferencePairCount = -1;
		
		String tempOption = null, tempOptionValue = null;
		try(Scanner in = new Scanner(System.in)){
			lunchMenuPairCount = in.nextInt();
			while(lunchMenuPairCount>0) {
				lunchMenuPairCount --;
				tempOption = in.next();
				tempOptionValue = in.next();
				Pair pair = new Pair(tempOption, tempOptionValue);
				lunchMenuPairs.add(pair);
			}
			
			teamCuisinePreferencePairCount = in.nextInt();
			while(teamCuisinePreferencePairCount >0) {
				teamCuisinePreferencePairCount--;
				
				tempOption = in.next();
				tempOptionValue = in.next();
				Pair pair = new Pair(tempOption, tempOptionValue);
				teamCuisinePreferencePairs.add(pair);
			}
		}
	}
	
	public static List<Pair> solve(List<Pair> lunchMenuPair, List<Pair> teamMenuPairs){
		List<Pair> result = new ArrayList<>();
		Map<String, Set<String>> map = new HashMap<>();
		
	}
	
	
	public static void main(String[] args) {
		
		List<Pair> lunchMenuPairs = new LinkedList<>();
		List<Pair> teamCuisinePreferencePairs = new LinkedList<>();
		inputAndSet(lunchMenuPairs, teamCuisinePreferencePairs);
		List<Pair> result = solve(lunchMenuPairs, teamCuisinePreferencePairs);
		
	}
}

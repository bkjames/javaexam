package ama01;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class LunchMenuHashServices {
	
	public static void main(String[] args) {
		String[][] lunchMealTypeHash = {
				 {"Pizza", "Italian"},
				 {"Curry", "Indian"},
				 {"Marsala","Indian"}
				};
		String[][] userLunchOptionHash= {
				{"Jose", "Italian"},
				{"John", "Indian" },
				{"Sarah", "*"}
		};
		LunchMenuHashServices lunch = new LunchMenuHashServices();
		String[][] output = lunch.matchLunch(lunchMealTypeHash, userLunchOptionHash );
		print(output);
	}
	
	public static void print(String[][] output) {
		for(int i=0; i<output.length;i++) {
			System.out.println(output[i][0]+ " "+output[i][1]);
		}
	}
	
	public String[][] matchLunch(String[][] lunchMenuPairs, String[][] teamCuisinePreference){
		
		String [][] pairings ;
		Map<String, String> entreeCuiSineHash = convertFromArrayToMap(lunchMenuPairs);
		Map<String, String> employeeCuiSineHash = convertFromArrayToMap(teamCuisinePreference);
		Map<String, String> employeeEntryHash = findCuiSineCorrelation(entreeCuiSineHash, employeeCuiSineHash);
		pairings = convertFromHashToArray(employeeEntryHash);
		return pairings;
	}
	
	public Map<String, String> convertFromArrayToMap(String[][] matrix){
		Map<String, String> hashMap = new HashMap<>();
		
		for(int row=0 ; row< matrix.length; row++) {
			int length = matrix[row].length;
			hashMap.put(matrix[row][0], matrix[row][length-1]);
		}
		return hashMap;
	}
	
	public String[][] convertFromHashToArray(Map<String, String> employeeEntreeHash){
		Set<String> employees =  employeeEntreeHash.keySet();
		String[][] finalArrayList = new String[employees.size()][2];
		int employeeId =0 ;
		for(String employee: employees) {
			finalArrayList[employeeId][0] = employee;
			finalArrayList[employeeId][1] = employeeEntreeHash.get(employee);
			employeeId++;
		}
		return finalArrayList;
	}
	
	public Map<String, String> findCuiSineCorrelation(Map<String, String> entryCuiSine, Map<String, String> employCuiSinePref){
		Map<String, String> result = new HashMap<>();
		for(String employee: employCuiSinePref.keySet()) {
			StringBuffer cuiSineList = new StringBuffer();
			String cuiSine = employCuiSinePref.get(employee);
			
			if(Objects.nonNull(cuiSine)) {
				for(String entree: entryCuiSine.keySet()) {
					if(cuiSine.equals("*")|| cuiSine.equals(entryCuiSine.get(entree))) {
						cuiSineList.append(entree+",");
					}
				}
				result.put(employee, cuiSineList.deleteCharAt(cuiSineList.length()-1).toString());
			}	
		}
		return result;
	}
}

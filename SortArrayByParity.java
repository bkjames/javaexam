package ama01;

public class SortArrayByParity {
	
	public static void main(String[] args) {
		int[] nums = {2,1,4,3};
		sortArrayByParity(nums);
	}
	
	public static int[] sortArrayByParity(int[] nums) {
		
		int[] arr = new int[nums.length];
		int begin =0;
		int end = nums.length-1;
		
		for(int i=0; i< nums.length; i++) {
			if(nums[i] %2==0) {
				arr[begin++] = nums[i];
			}else {
				arr[end--]= nums[i];
			}
		}
		return arr;
	}

	
}

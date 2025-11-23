package data_structure;

public class CountingSort {
	public static void countingSort(int[] nums) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<nums.length;i++) {
			if(nums[i] > max) {
				max = nums[i];
			}
			if(nums[i] < min) {
				min = nums[i];
			}
		}
		int[] sorted = new int[max-min+1];
		for(int i = 0;i<nums.length;i++) {
			sorted[nums[i]-min]++;
		}
		
		for(int i = 0;i<sorted.length;i++) {
			while(sorted[i] > 0) {
				System.out.print(i+min+" ");
				sorted[i]--;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {6,2,4,3,1,5,9,8,7,1,3,2,3,2,7};
		countingSort(nums);
	}
}

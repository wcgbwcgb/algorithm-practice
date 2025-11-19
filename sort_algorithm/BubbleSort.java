package data_structure;

public class BubbleSort {

	public static void bubbleSort(int[] nums) {
		int n = nums.length;
		int sorted = 0;
		
		while(sorted < n) {
			boolean s = false;
			for(int i = n-1;i>sorted;i--) {
				if(nums[i] < nums[i-1]) {
					swap(nums, i, i-1);
					s = true;
				}
			}
			if(!s) {
				return;
			}
			
			sorted++;
		}
		
	}
	
	private static void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {6,2,4,3,1,5,9,8,7};
		bubbleSort(nums);
		for(int num:nums) {
			System.out.print(num + " ");
		}
	}
}

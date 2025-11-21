package data_structure;

public class InsertionSort {
	public static void insertionSort(int[] nums) {
		int sorted = 0;
		while(sorted<nums.length-1) {
			for(int i = sorted;i>=0;i--) {
				if(nums[i+1] < nums[i]) {
					swap(nums, i+1, i);
				}else {
					break;
				}
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
		insertionSort(nums);
		for(int num:nums) {
			System.out.print(num + " ");
		}
	}
}

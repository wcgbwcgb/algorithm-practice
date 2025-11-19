package data_structure;

public class SelectionSort {
	
	// O(n^2), unstable
	public static void selectionSort(int[] nums) {
		for(int i = 0;i<nums.length;i++) {
			int minidx = i;
			for(int j = i+1;j<nums.length;j++) {
				if(nums[j] < nums[minidx]) {
					minidx = j;
				}
			}
			if(minidx != i) {
				swap(nums, i, minidx);
			}
		}
	}
	
	// stable
	public static void betterSelectionSort(int[] nums) {
		for(int i = 0;i<nums.length;i++) {
			int minidx = i;
			for(int j = i+1;j<nums.length;j++) {
				if(nums[j] < nums[minidx]) {
					minidx = j;
				}
			}
			if(minidx != i) {
				int temp = nums[i];
				nums[i] = nums[minidx];
				for(int j = minidx-1; j>i;j--) {
					nums[j+1] = nums[j];
				}
				nums[i+1] = temp;
			}
		}
	}
	
	private static void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {6,2,4,3,1,5,9,8,7};
		betterSelectionSort(nums);
		for(int num:nums) {
			System.out.print(num + " ");
		}
		
	}
}

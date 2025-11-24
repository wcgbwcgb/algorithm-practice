package data_structure;

import java.util.ArrayList;

public class BucketSort {
	public static void bucketSort(int[] nums, int bucketCount) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i: nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		int offset = -min;
		
		int bucketSize = (max - min) / bucketCount + 1;
		
		// create buckets
		ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
		for(int i = 0;i<bucketCount;i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		// separate elements into different buckets
		for(int i = 0;i<nums.length;i++) {
			int idx = (nums[i]+offset) / bucketSize;
			buckets[idx].add(nums[i]);
		}
		
		// sort numbers in each buckets
		for(int i = 0; i<bucketCount;i++) {
			insertionSort(buckets[i]);
		}
		
		// combine the result
		int index = 0;
		for(int i = 0;i<bucketCount;i++) {
			for(int num:buckets[i]) {
				nums[index] = num;
				index++;
			}
		}
	}
	
	private static void insertionSort(ArrayList<Integer> nums) {
		int sorted = 0;
		while(sorted < nums.size()) {
			for(int i = sorted;i>0;i--) {
				if(nums.get(i) < nums.get(i-1)) {
					int temp = nums.get(i);
					nums.set(i, nums.get(i-1));
					nums.set(i-1, temp);
				}else {
					break;
				}
			}
			sorted++;
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums = {6,2,4,3,1,5,9,8,7,1,3,2,3,2,7};
		bucketSort(nums, 2);
		for(int num:nums) {
			System.out.print(num+" ");
		}
	}
	
}

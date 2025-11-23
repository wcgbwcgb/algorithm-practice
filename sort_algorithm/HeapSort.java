package data_structure;

public class HeapSort {
	public static void heapSort(int[] nums) {
		SimpleMinPQ heap = new SimpleMinPQ(nums.length);
		for(int i: nums) {
			heap.push(i);
		}
		int sz = heap.size();
		for(int i = 0;i<sz;i++) {
			nums[i] = heap.pop();
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {6,2,4,3,1,5,9,8,7};
		heapSort(nums);
		for(int num:nums) {
			System.out.print(num + " ");
		}
	}
}

package data_structure;

public class ImprovedHeapSort {
	
	private void sink(int[] nums, int index, int size) {
		int left = index*2 + 1;
		int right = index*2 + 2;
		int min = index;
		
		while(left < size || right < size) {
			left = index*2 + 1;
			right = index*2 + 2;
			min = index;
			if(left < size && nums[left] > nums[min]) {
				min = left;
			}
			if(right < size && nums[right] > nums[min]) {
				min = right;
			}
			if(min == index) {
				break;
			}
			swap(nums, index, min);
			index = min;
		}
	}
	
	private void swim(int[] nums, int index) {
		if(index < 1 || nums[index] <= nums[(index-1)/2]) {
			return;
		}
		swap(nums, index, (index-1)/2);
		swim(nums, (index-1)/2);
	}
	
	private void swap(int[] nums, int idx1, int idx2) {
		int temp;
		temp = nums[idx2];
		nums[idx2] = nums[idx1];
		nums[idx1] = temp;
	}
	
	public void improvedHeapSort(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			swim(nums, i);
		}
		
		int size = nums.length;
		while(size>0) {
			swap(nums, 0, size-1);
			size--;
			sink(nums, 0, size);
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums = {6,2,4,3,1,5,9,8,7};
		ImprovedHeapSort sorter = new ImprovedHeapSort();
		sorter.improvedHeapSort(nums);
		for(int num:nums) {
			System.out.print(num + " ");
		}
	}

}

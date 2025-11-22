package data_structure;

public class ShellSort {
	public static void shellSort(int[] nums) {
		for(int d = nums.length/2;d>=1;d/=2) {
			for(int i = d;i<nums.length;i++) {
				if(nums[i] < nums[i-d]) {
					int temp = nums[i];
					int j = i - d;
					// finding the insert position of temp, j can not be smaller than 0
					while(j>=0 && nums[j] > temp) {
						nums[j+d] = nums[j];
						j -= d;
					}
					// j不满足while条件退出，因此需要+d
					nums[j+d] = temp;
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] nums = {6,2,4,3,1,5,9,8,7};
		shellSort(nums);
		for(int num:nums) {
			System.out.print(num + " ");
		}
	}
}

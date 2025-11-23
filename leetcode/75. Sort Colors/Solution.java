class Solution {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        int idx = 0;
        for(int element = 0;element<3;element++){
            for(int i=0;i < arr[element];i++){
                nums[idx] = element;
                idx++;
            }
        }
    }
}
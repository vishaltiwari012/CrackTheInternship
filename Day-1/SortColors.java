class Solution {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        // Arrays.sort(nums);
        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }
}
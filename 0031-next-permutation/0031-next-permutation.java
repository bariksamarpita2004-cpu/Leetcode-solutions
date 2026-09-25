class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        // Step 1: Find the first decreasing element from the right
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // Step 2: If the array is not entirely descending
        if (i >= 0) {
            int j = nums.length - 1;
            // Find the element largest than nums[i] from the right
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        // Step 3: Reverse the descending suffix to get the smallest sequence
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

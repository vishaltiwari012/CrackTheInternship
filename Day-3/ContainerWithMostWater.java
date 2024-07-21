class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * minHeight);
            while (left < height.length && height[left] <= minHeight) {
                left++;
            }
            while (right > 0 && height[right] <= minHeight) {
                right--;
            }
        }
        return maxArea;
    }
}
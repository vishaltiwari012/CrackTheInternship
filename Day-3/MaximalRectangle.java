package Day-3;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        int[] heights = new int[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    heights[j]++;
                }
                else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestArea(heights));
        }
        return maxArea;
    }

    public static int largestArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i <= n; i++) {
            int currHeight = i == n ? 0 : heights[i];
            while(!st.isEmpty() && currHeight <= heights[st.peek()]) {
                int top = st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(area, maxArea);
            }

            st.push(i);
        }
        return maxArea;
    }
} {
    
}

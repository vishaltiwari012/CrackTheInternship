class Solution {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        // your code here
        Collections.sort(a);
        int left = 0;
        int right = m - 1;
        long finalRes = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            if (right < a.size()) {
                long res = a.get(right) - a.get(left);
                finalRes = Math.min(finalRes, res);
            } else {
                break;
            }
            left++;
            right++;
        }
        return finalRes;
    }
}
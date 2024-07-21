class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int start, int n, int k, List<List<Integer>> res, List<Integer> temp) {
        if(temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(i + 1, n, k, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
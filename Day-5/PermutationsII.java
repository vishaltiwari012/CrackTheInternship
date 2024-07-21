class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]))
                continue;
            temp.add(nums[i]);
            visited[i] = true;
            backtrack(res, nums, temp, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
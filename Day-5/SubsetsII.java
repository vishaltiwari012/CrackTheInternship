class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums, int start,  List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, i + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
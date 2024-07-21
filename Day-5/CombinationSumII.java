class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, target, new ArrayList<>(), list);
        return list;
    }

    public void backtrack(int start, int[] nums, int target, List<Integer> temp, List<List<Integer>> list) {
        if(target < 0) return;
        if(target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        else {
            for(int i = start; i < nums.length; i++) {
                if(i > start && nums[i] == nums[i - 1]) continue;
                temp.add(nums[i]);
                backtrack(i + 1, nums, target - nums[i], temp, list);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
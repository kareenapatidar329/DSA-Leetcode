class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, ans);

        return ans;
    }

    private void backtrack(
            int start,
            int[] nums,
            List<Integer> current,
            List<List<Integer>> ans) {

        // Store a copy of the current subset
        ans.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Include the current element
            current.add(nums[i]);

            // Explore remaining elements
            backtrack(i + 1, nums, current, ans);

            // Backtrack: exclude the current element
            current.remove(current.size() - 1);
        }
    }
}
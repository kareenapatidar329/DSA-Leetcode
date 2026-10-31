class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, current, ans);

        return ans;
    }

    private void backtrack(
        int[] candidates,
        int remaining,
        int start,
        List<Integer> current,
        List<List<Integer>> ans
    ) {

        if (remaining == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate elements at the same level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Remaining candidates are too large
            if (candidates[i] > remaining) {
                break;
            }

            current.add(candidates[i]);

            // i+1 because each element can be used only once
            backtrack(
                candidates,
                remaining - candidates[i],
                i + 1,
                current,
                ans
            );

            // Backtracking
            current.remove(current.size() - 1);
        }
    }
}
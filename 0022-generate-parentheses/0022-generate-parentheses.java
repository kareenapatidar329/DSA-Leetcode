import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        backtrack(n, 0, 0, current, ans);

        return ans;
    }

    private void backtrack(
        int n,
        int open,
        int close,
        StringBuilder current,
        List<String> ans
    ) {

        // Base case
        if (current.length() == 2 * n) {
            ans.add(current.toString());
            return;
        }

        // Choice 1: Add opening bracket
        if (open < n) {

            current.append('(');

            backtrack(n, open + 1, close, current, ans);

            // Backtracking
            current.deleteCharAt(current.length() - 1);
        }

        // Choice 2: Add closing bracket
        if (close < open) {

            current.append(')');

            backtrack(n, open, close + 1, current, ans);

            // Backtracking
            current.deleteCharAt(current.length() - 1);
        }
    }
}
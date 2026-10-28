import java.util.*;

class Solution {
public List<List<Integer>> subsets(int[] nums) {
List<List<Integer>> result = new ArrayList<>();
result.add(new ArrayList<>());

    for (int num : nums) {
        List<List<Integer>> newSubsets = new ArrayList<>();

        for (List<Integer> subset : result) {
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(num);
            newSubsets.add(newSubset);
        }

        result.addAll(newSubsets);
    }

    return result;
}

}

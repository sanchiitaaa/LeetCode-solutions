class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(0, candidates, target, temp, ans);

        return ans;
    }

    void solve(int index, int[] candidates, int target,
               List<Integer> temp, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        // Pick the current element
        temp.add(candidates[index]);
        solve(index, candidates, target - candidates[index], temp, ans);

        // Backtrack
        temp.remove(temp.size() - 1);

        // Skip the current element
        solve(index + 1, candidates, target, temp, ans);
    }
}
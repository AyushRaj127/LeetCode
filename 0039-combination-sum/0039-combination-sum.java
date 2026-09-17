class Solution {
    private void combinations(int[] candidates, int target, int i, int sum, List<Integer> current, List<List<Integer>> result) {
        if (i == candidates.length || sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(candidates[i]);
        combinations(candidates, target, i, sum + candidates[i], current, result);

        current.remove(current.size() - 1);
        combinations(candidates, target, i + 1, sum, current, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        combinations(candidates, target, 0, 0, current, result);

        return result;
    }
}
class Solution {
    private void combinations(int[] candidates, int target, int i, List<Integer> current, List<List<Integer>> result) {
        if (i == candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(candidates[i]);
        combinations(candidates, target - candidates[i], i, current, result);

        current.remove(current.size() - 1);
        combinations(candidates, target, i + 1, current, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        combinations(candidates, target, 0, current, result);

        return result;
    }
}
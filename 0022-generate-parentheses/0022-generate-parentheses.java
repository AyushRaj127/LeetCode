class Solution {
    private void generate(List<String> result, String current, int n, int open, int close) {
        if (open == n && close == n) {
            result.add(current);
            return;
        }

        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            current += "(";
            generate(result, current, n, open + 1, close);
            current = current.substring(0, current.length() - 1);
        }
        
        if (close < n && close < open) {
            current += ")";
            generate(result, current, n, open, close + 1);
            current = current.substring(0, current.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String current = "";

        generate(result, current, n, 0, 0);

        return result;
    }
}
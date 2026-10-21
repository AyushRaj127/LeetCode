class Solution {
    private void generate(int n, StringBuilder current, List<String> result) {
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }

        current.append('1');
        generate(n, current, result);
        current.deleteCharAt(current.length() - 1);

        if (current.length() == 0 || current.charAt(current.length() - 1) != '0') {
            current.append('0');
            generate(n, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        
        generate(n, new StringBuilder(), result);

        return result;
    }
}
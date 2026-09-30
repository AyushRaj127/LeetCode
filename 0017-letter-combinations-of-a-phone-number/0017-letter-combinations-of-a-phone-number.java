class Solution {
    private void combinations(int index, String digits, String[] letters, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        int i = digits.charAt(index) - '0';
        String letter = letters[i];

        for (int j = 0; j < letter.length(); j++) {
            current.append(letter.charAt(j));
            combinations(index + 1, digits, letters, current, result);

            current.deleteCharAt(current.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();

        combinations(0, digits, letters, new StringBuilder(), result);
        return result;
    }
}
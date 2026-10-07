class Solution {
    private boolean isValid(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;

                if (count < 0)
                    return false;
            }
        }

        return count == 0;
    }

    private void remove(String s, int index, int left, int right, String valid, Set<String> result) {
        if (index == s.length()) {
            if (left == 0 && right == 0 && isValid(valid)){
                result.add(valid);
            }
            
            return;
        }

        char c = s.charAt(index);

        if (c == '(' && left > 0) {
            remove(s, index + 1, left - 1, right, valid, result);
        }

        if (c == ')' && right > 0) {
            remove(s, index + 1, left, right - 1, valid, result);
        }

        remove(s, index + 1, left, right, valid + c, result);
    }

    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) ==')') {
                if (left > 0) left--;
                else right++;
            }
        }

        remove(s, 0, left, right, "", result);
        return new ArrayList<>(result);
    }
}
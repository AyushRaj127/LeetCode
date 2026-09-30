class Solution {
    private boolean isPalindrome(String sub, int left, int right) {
        while (left < right) {
            if (sub.charAt(left) != sub.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    
    private void check(int index, String s, List<String> current, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);

            if (isPalindrome(sub, 0, sub.length() - 1)) {
                current.add(sub);
                check(i + 1, s, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        check(0, s, current, result);
        return result;
    }
}
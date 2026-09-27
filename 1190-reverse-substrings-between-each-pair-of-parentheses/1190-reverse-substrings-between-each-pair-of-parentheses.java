class Solution {
    private void reverse(char[] c, int left, int right) {
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;

            left++;
            right--;
        }
    }
    
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.push(i);
            } else if (c[i] == ')') {
                int left = stack.pop();
                reverse(c, left + 1, i - 1);
            }
        }

        StringBuilder result = new StringBuilder();

        for (char ch : c) {
            if (ch != '(' && ch != ')') {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
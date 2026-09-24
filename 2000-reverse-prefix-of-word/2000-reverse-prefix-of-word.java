class Solution {
    public String reversePrefix(String word, char ch) {
        int left = 0;
        int right = word.indexOf(ch);

        if (right == -1) {
            return word;
        }

        char[] chars = word.toCharArray();

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        word = new String(chars);
        return word;
    }
}
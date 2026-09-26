class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> seen = new HashMap<>();

        for (List<String> word : knowledge) {
            seen.put(word.get(0), word.get(1));
        }
        
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(")", i + 1);
                ans.append(seen.getOrDefault(s.substring(i + 1, j), "?"));
                i = j;
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
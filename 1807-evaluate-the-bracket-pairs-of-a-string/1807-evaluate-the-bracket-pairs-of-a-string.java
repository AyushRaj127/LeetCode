class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> seen = new HashMap<>();

        for (List<String> word : knowledge) {
            seen.put(word.get(0), word.get(1));
        }
        
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                StringBuilder sb = new StringBuilder();
                i++;

                while (s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                    i++;
                }

                if (seen.containsKey(sb.toString())) {
                    ans.append(seen.get(sb.toString()));
                } else {
                    ans.append("?");
                }
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
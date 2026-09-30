class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();

        for (String s : words) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);
            }

            return a.compareTo(b);
        });

        for (String s : freq.keySet()) {
            pq.offer(s);
        }

        List<String> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
            k--;

            if (k == 0) break;
        }

        return result;
    }
}
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int sum = 0;
        int totalSum = 0;

        for (int point : cardPoints) {
            totalSum += point;
        }

        if (cardPoints.length - k == 0) {
            return totalSum;
        }

        for (int i = 0; i < cardPoints.length - k; i++) {
            sum += cardPoints[i];
        }

        int minSum = sum;

        for (int right = cardPoints.length - k; right < cardPoints.length; right++) {
            sum += cardPoints[right];
            sum -= cardPoints[left];

            minSum = Math.min(sum, minSum);
            left++;
        }

        return totalSum - minSum;
    }
}
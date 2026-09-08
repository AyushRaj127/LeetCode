class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum / k >= threshold) count++;

        for (int right = k; right < arr.length; right++) {
            sum += arr[right];
            sum -= arr[left];
            left++;

            if (sum / k >= threshold) count++;
        }

        return count;
    }
}
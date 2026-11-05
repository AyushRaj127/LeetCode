class Solution {
    private int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count = 0;

        for (int x : arr1) {
            int low = x - d;
            int high = x + d;
            int index = lowerBound(arr2, low);

            if (index == arr2.length || arr2[index] > high) {
                count++;
            }
        }

        return count;
    }
}
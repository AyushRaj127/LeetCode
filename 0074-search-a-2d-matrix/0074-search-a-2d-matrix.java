class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int outerLeft = 0;
        int outerRight = matrix.length - 1;

        while (outerLeft <= outerRight) {
            int outerMid = outerLeft + (outerRight - outerLeft) / 2;
            int left = 0;
            int right = matrix[0].length - 1;

            if (matrix[outerMid][left] <= target && matrix[outerMid][right] >= target) {
                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (matrix[outerMid][mid] == target) {
                        return true;
                    } else if (matrix[outerMid][mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                return false;
            } else if (matrix[outerMid][left] <= target && matrix[outerMid][right] <= target) {
                outerLeft = outerMid + 1;
            } else {
                outerRight = outerMid - 1;
            }
        }

        return false;
    }
}
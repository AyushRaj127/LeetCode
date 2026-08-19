class Solution {
    public double averageWaitingTime(int[][] customers) {
        int sum = customers[0][0] + customers[0][1];
        double time = customers[0][1];

        for (int i = 1; i < customers.length; i++) {
            if (customers[i][0] <= sum) {
                sum += customers[i][1];
                time += (sum - customers[i][0]);
            } else {
                while (sum < customers[i][0]) {
                    sum++;
                }

                sum += customers[i][1];
                time += (sum - customers[i][0]);
            }
        }

        return (time) / customers.length;
    }
}
class Solution {
    public double averageWaitingTime(int[][] customers) {
        long curr = 0;
        long wait = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int finish = customer[1];

            curr = Math.max(curr, arrival) + finish;
            wait += curr - arrival;
        }

        return (double) wait / customers.length;
    }
}
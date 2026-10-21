class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        if (arrivalTime + delayedTime > 24) {
            int newTime = (arrivalTime + delayedTime) % 24;
            return newTime;
        }

        return arrivalTime + delayedTime == 24 ? 0 : arrivalTime + delayedTime;
    }
}
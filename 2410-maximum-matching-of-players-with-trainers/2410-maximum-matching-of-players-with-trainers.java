class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int left = 0;
        int right = 0;
        int count = 0;

        Arrays.sort(players);
        Arrays.sort(trainers);

        while (left < players.length && right < trainers.length) {
            if (players[left] <= trainers[right]) {
                count++;
                left++;
            }

            right++;
        }

        return count;
    }
}
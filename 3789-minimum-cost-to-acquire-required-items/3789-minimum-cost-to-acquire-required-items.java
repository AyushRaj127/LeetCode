class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long both = Math.min(costBoth, cost1 + cost2);
        int min = Math.min(need1, need2);
        long ans = 0;

        ans += both * min;
        need1 -= min;
        need2 -= min;

        ans += Math.min(cost1, costBoth) * (long) need1;
        ans += Math.min(cost2, costBoth) * (long) need2;

        return ans;
    }
}
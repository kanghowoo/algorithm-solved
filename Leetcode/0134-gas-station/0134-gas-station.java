class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int result = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];

            tank += diff;
            total += diff;

            if (tank < 0) {
                tank = 0;
                result = i + 1;
            }
        }

        if (total < 0) {
            return -1;
        }

        return result;
    }
}
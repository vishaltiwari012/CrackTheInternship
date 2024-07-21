class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int n = gas.length;
        for(int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) return -1;
        int total = 0, start = 0;
        for(int i = 0; i < n; i++) {
            total += gas[i];
            total -= cost[i];
            if(total < 0) {
                start = i + 1;
                total = 0;
            }
        }
        return start;
    }
}
package greedy;

public class BuyStockI {
    public int maxProfit(int[] array) {
        // Write your solution here
        int curMin = array[0];
        int maxProfit = 0;
        for (int i = 1; i < array.length; i++) {
            maxProfit = Math.max(array[i] - curMin, maxProfit);
            curMin = Math.min(curMin, array[i]);
        }
        return maxProfit;
    }
}

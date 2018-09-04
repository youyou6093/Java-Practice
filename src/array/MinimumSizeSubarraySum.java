package array;

public class MinimumSizeSubarraySum {

    public static void main(String[] args){
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(4, new int[] {2, 4}));
    }
    public int minSubArrayLen(int num, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int curSum = nums[j];
        int curBest = Integer.MAX_VALUE;
        while (j < nums.length) {
            if (curSum >= num) {
                curBest = Math.min(j - i + 1, curBest);
                curSum -= nums[i];
                i++;
            } else if(curSum < num && j < nums.length - 1) {
                j++;
                curSum += nums[j];
            } else {
                break;
            }
        }
        return curBest == Integer.MAX_VALUE ? 0 : curBest;
    }
}

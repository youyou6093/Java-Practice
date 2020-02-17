package CrossTraining5;



public class MaxWaterTrapped {
    public int maxTrapped(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] dp1 = new int[array.length];
        int[] dp2 = new int[array.length];
        dp1[0] = array[0];
        dp2[array.length - 1] = array[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            dp1[i] = Math.max(array[i], dp1[i - 1]);
        }
        for (int i = array.length - 2; i >=0; i--) {
            dp2[i] = Math.max(array[i], dp2[i + 1]);
        }
        int ret = 0;
        for (int i = 0; i < array.length; i++) {
            ret += Math.min(dp1[i], dp2[i]) - array[i];
        }
        return ret;
    }
}

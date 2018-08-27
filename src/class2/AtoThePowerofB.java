package class2;


public class AtoThePowerofB {
    public long power(int a, int b) {
        // Write your solution here
        if (b == 0) {
            return 1;
        } else {
            long half = power(a, b / 2);
            if (b % 2 == 0) {
                return half * half;
            } else {
                return a * half * half;
            }
        }
    }
}

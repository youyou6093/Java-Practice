package class15Sampling;
import java.util.*;



public class Random7UsingRandom5 {
    private int random5() {
        return new Random().nextInt(5);

    }
    public int random7() {
        while(true) {
            int val = random5() * 5 + random5();
            if (val < 21) {
                return val % 7;
            }
        }
    }
}

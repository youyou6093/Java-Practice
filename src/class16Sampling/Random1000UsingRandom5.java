package class16Sampling;

import java.util.Random;

//checked

public class Random1000UsingRandom5 {
    private int random5() {
        return new Random().nextInt(5);

    }
    public int random1000() {
        int count = 1;
        while (true) {
            int val = 0;
            while (count < 1000) {
                count *= 5;
                val = val * 5 + random5();
            }
            if (val < (count) / 1000 * 1000) {
                return val % 1000;
            }
        }
    }
}

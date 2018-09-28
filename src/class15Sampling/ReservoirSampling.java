package class15Sampling;
import java.util.*;


public class ReservoirSampling {
    private int count;
    private Integer sample;
    Random random = new Random();
    public ReservoirSampling() {
    }

    public void read(int value) {
        count++;
        if(random.nextInt(count) == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        return sample;
    }
}

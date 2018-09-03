import java.util.*;

public class TestFile {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5};
        List<Integer> x = Arrays.asList(array);
        x.set(2, 9);
        System.out.println(array[2]);
    }
}




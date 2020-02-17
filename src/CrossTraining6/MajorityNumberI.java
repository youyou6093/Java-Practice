package CrossTraining6;



public class MajorityNumberI {
    public int majority(int[] array) {
        int ret = array[0];
        int num = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == ret) {
                num++;
            } else {
                if (num == 0) {
                    num = 1;
                    ret = array[i];
                } else {
                    num--;
                }
            }
        }
        return ret;

    }
}

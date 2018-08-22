public class KCloest {
    public int[] findKcloest(int[] array, int k, int target){
        int[] ret = new int[k];
        int l = 0, r = array.length - 1, m = 0;
        while(l < r - 1){
            m = l + (r - l) / 2;
            if(array[m] < target){
                l = m;
            }else if(array[m] > target) {
                r = m;
            }else{
                break;
            }
        }
        int index = 0;
        while(index < k && l >= 0 && r < array.length){
            if( Math.abs(array[l] - target) <= Math.abs(array[r] - target)){
                ret[index++] = array[l--];
            }else{
                ret[index++] = array[r++];
            }
        }
        if(l<0){
            while(index < k){
                ret[index++] = array[r++];
            }
        }else{
            while(index < k) {
                ret[index++] = array[l--];
            }
        }
        return ret;

    }
}

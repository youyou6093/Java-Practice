package class2;


/*
 *  interface Dictionary {
 *    public Integer get(int index);
 *  }
 */

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class SearchInUnknownSizedSortedArray {
    interface Dictionary {
        public Integer get(int index);
    }
    public int search(Dictionary dict, int target) {
        // Write your solution here
        int size = 2;
        while (dict.get(size) != null &&  dict.get(size) < target) {
            size *= 2;
        }
        int left = 0, right = size;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null || dict.get(mid) > target) {
                right = mid - 1;
            } else if (dict.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }


        return -1;
    }
}

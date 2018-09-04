package array;

public class SearchInShiftedSortedArray {
    public int search(int[] array, int target) {
        // Write your solution here
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //check mid is in right half or left half
            if (array[mid] >= array[left]) {      //left half
                if (array[mid] > target) {
                    if (target >= array[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (array[mid] > target) {
                    right = mid - 1;
                } else if (array[mid] < target) {
                    if (target <= array[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}

package CrossTraining6;

//use quick select is better
public class KthSmallestInTwoSortedArray {
    public int kth(int[] a, int[] b, int k) {
        return findK(a, b, 0, 0, k);
    }


    public int findK(int[] a, int[] b, int lefta, int leftb, int k) {
        if (a.length <= lefta) {
            return b[leftb + k - 1];
        }
        if (b.length <= leftb) {
            return a[lefta + k - 1];
        }
        if (k == 1) {
            return Math.min(a[lefta], b[leftb]);
        }
        int mid1 = lefta + k / 2 - 1 < a.length ? a[lefta + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = leftb + k / 2 - 1 < b.length ? b[leftb + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 > mid2) {
            return findK(a, b, lefta, leftb + k / 2, k - k / 2);
        } else {
            return findK(a, b, lefta + k / 2, leftb, k - k / 2);
        }
    }
}





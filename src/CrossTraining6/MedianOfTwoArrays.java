package CrossTraining6;


import java.util.Arrays;

import static java.lang.Math.min;

public class MedianOfTwoArrays {
    public double median(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = nums1.length + nums2.length;
        if (l % 2 == 0) {
            int a = findK(nums1, nums2, 0, 0, l / 2);
            int b = findK(nums1, nums2, 0, 0, l / 2 + 1);
            return (a * 1.0 + b) / 2;
        } else {
            int a = findK(nums1, nums2, 0, 0, l / 2 + 1);
            return  1.0 * a;
        }
    }

    int findK(int[] nums1, int[] nums2, int left1, int left2, int k) {
        if (nums1.length <= left1) {
            return nums2[left2 + k - 1];
        }
        if (nums2.length <= left2) {
            return nums1[left1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }
        int mid1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 > mid2) {
            return findK(nums1, nums2, left1, left2 + k / 2, k - k / 2);
        } else {
            return findK(nums1, nums2, left1 + k / 2, left2, k - k / 2);
        }
    }
};
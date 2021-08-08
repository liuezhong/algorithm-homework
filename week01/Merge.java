public class Merge {

    /**
     * 88. 合并两个有序数组
     */

    //    方法1

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            nums1 = nums1 == null ? nums2 : nums1;
        }
        int tail = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[tail--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[tail--] = nums1[p1--];
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[tail--] = nums1[p1--];
            }else {
                nums1[tail--] = nums2[p2--];
            }
        }
    }

//    方法2
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            nums1 = nums1 == null ? nums2 : nums1;
        }
        int loc = 0;
        int[] newArr = new int[m + n];
        int left = 0;
        int right =0;
        while (left < m || right< n) {
            if(left == m) {
                newArr[loc++] = nums2[right++];
            }else if (right == n) {
                newArr[loc++] = nums1[left++];
            }else if (nums1[left] <= nums2[right]){
                newArr[loc++] = nums1[left++];
            }else {
                newArr[loc++] = nums2[right++];
            }
        }

        System.arraycopy(newArr, 0, nums1, 0, m + n);
    }



    public static void main(String[] args) {
        Merge m = new Merge();
        m.merge(new int[]{1,2,3,0,0,0}, 6, new int[]{2, 5, 6}, 3 );
    }
}

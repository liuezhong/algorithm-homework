
/**
 * @ClassName:  ReversePairs
 * @Description: 493. 翻转对
 * @link: https://leetcode-cn.com/problems/reverse-pairs/
 * @author: liuezhong
 * @date:   2021/9/30 下午10:44
*/

public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return 0;
        }
        int count = 0;
        int mid = left + (right - left) / 2;
        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += findReversedPairs(nums, left, right);
        merge(nums, left, mid, right);
        return count;
    }

    private void merge (int[] nums, int left, int mid, int right) {
        int[] numsSorted = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            numsSorted[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            numsSorted[k++] = nums[i++];
        }
        while (j <= right) {
            numsSorted[k++] = nums[j++];
        }
        for (int p = 0; p < numsSorted.length; p++) {
            nums[left + p] = numsSorted[p];
        }
    }
    private int findReversedPairs(int[] nums,int left,int right){
        int res = 0,mid = left + (right-left)/2;
        int j = mid + 1;
        for(int i = left; i <= mid;i++){
            while(j <= right && (long)nums[i] > 2*(long)nums[j]) {
                res += mid - i + 1;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReversePairs r = new ReversePairs();
        System.out.println(r.reversePairs(new int[] {1,3,2,3,1}));
    }
}

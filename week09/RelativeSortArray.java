/**
 * @ClassName:  RelativeSortArray
 * @Description: 1122. 数组的相对排序
 * @link: https://leetcode-cn.com/problems/relative-sort-array/
 * @author: liuezhong
 * @date:   2021/9/30 下午10:47
*/

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] hash = new int[1001];
        int[] result = new int[arr1.length];
        int index = 0;
        for (int ele : arr1) {
            hash[ele]++;
        }
        for (int ele : arr2) {
            while (hash[ele] > 0) {
                result[index++] = ele;
                hash[ele]--;
            }
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                result[index++] = i;
                hash[i]--;
            }
        }
        return result;
    }
}

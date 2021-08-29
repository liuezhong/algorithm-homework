/**   
 * @ClassName:  SearchMatrix
 * @Description: 74. 搜索二维矩阵
 * @link: https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author: liuezhong
 * @date:   2021/8/28 下午4:40    
*/ 

public class SearchMatrix {

    /*
    * 二分查找
    * 时间复杂度：O(log(mn))，空间复杂度：O(1)
    * */

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int midX = mid / matrix[0].length;
            int midY = mid % matrix[0].length;
            if (target == matrix[midX][midY]) {
                return true;
            }
            if (target < matrix[midX][midY]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}

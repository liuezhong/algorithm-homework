public class MoveZeroes {

    /**
     *283. 移动零
     */

    public void moveZeroes(int[] nums) {
        int loc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != loc) {
                    nums[loc] = nums[i];
                    nums[i] = 0;
                }
                loc++;
            }
        }
    }
}

public class Rotate {
//    189. 旋转数组

    //    第一种解法
    public void rotate2(int[] nums, int k) {
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, nums.length);
    }


    //    第二种解法：数组翻转

    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0 ,nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //    第三种解法：环形替换

    public void rotate(int[] nums, int k) {
        int len  = nums.length;
        k = k % len;
        int count = 0;
        for(int start = 0; count < len; start++) {
            int cur = start;
            int pre = nums[cur];
            do{
                int next = (cur + k) % len;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            }while(start != cur)  ;

        }
    }
}

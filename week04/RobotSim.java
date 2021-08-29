import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:  RobotSim
 * @Description: 874. 模拟行走机器人
 * @link: https://leetcode-cn.com/problems/walking-robot-simulation/description/
 * @author: liuezhong
 * @date:   2021/8/28 上午10:41    
*/ 

public class RobotSim {
    /*
    *
    * 时间复杂度：O(N + K)，空间复杂度：O(K),其中N、K分别为commands、obstacles的长度
    * */

    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length == 0) {
            return 0;
        }
        int[] dirX = new int[]{0, 1, 0 , -1};
        int[] dirY = new int[]{1, 0, -1, 0};
//        direction代表当前方向，0：北，1：东，2：南，3：西
        int direction = 0;
        int distance = 0;
        int x = 0;
        int y = 0;
        Set<String> blockSet = new HashSet<>();
        for (int[] block : obstacles) {
            blockSet.add(block[0] + "," + block[1]);
        }
        for (int i = 0; i < commands.length; i++) {
//            左转
            if (commands[i] == -2) {
                direction = (direction + 3) % 4;
                continue;
            }
//            右转
            if (commands[i] == -1) {
                direction = (direction + 1) % 4;
                continue;
            }
            for (int j = 1; j <= commands[i]; j++) {
                int nextX = x + dirX[direction];
                int nextY = y + dirY[direction];
                if (blockSet.contains(nextX + "," + nextY)) {
                    break;
                }
                x = nextX;
                y = nextY;
                distance = Math.max(distance, x * x + y * y);

            }
        }
        return distance;
    }
}

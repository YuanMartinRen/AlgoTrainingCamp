/*
 * @lc app=leetcode id=874 lang=java
 *
 * [874] Walking Robot Simulation
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles)
            set.add(obs[0] + " " + obs[1]);
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0, dist = 0;
        for (int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
            } else if (c == -2) {
                d = (d + 3) % 4;
            } else {
                while (c-- > 0 && (!set.contains((x + dirs[d][0]) + " " + (y + dirs[d][1])))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            dist = Math.max(dist, x * x + y * y);
        }
        return dist;
    }
}
// @lc code=end


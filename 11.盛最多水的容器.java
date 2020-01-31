/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (60.75%)
 * Likes:    1071
 * Dislikes: 0
 * Total Accepted:    129.1K
 * Total Submissions: 212.4K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int maxValue = 0;
        int head = 0;
        int tail = height.length - 1;
        while(head < tail) {
            if(height[tail] > height[head]) {
                if(height[head] * (tail - head) > maxValue) {
                    maxValue = height[head] * (tail - head) ;
                }
                head ++;
            } else{
                if(height[tail] * (tail - head) > maxValue){
                    maxValue =  height[tail] * (tail - head);
                }
                tail --;
            } 
        }
    
        return maxValue;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 *
 * https://leetcode-cn.com/problems/sort-an-array/description/
 *
 * algorithms
 * Medium (53.35%)
 * Likes:    98
 * Dislikes: 0
 * Total Accepted:    46.9K
 * Total Submissions: 79.2K
 * Testcase Example:  '[5,2,3,1]'
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    
    public void quickSort(int[] nums, int start, int end) {
        if(start >= end) return;
        int left = start;
        int right = end;
        int pivot = nums[start];
        while(left < right) {
            while(left < right && pivot < nums[right] ) {
                right--;
            }
            if(left < right) {
                nums[left] = nums[right];
                left++;
            }
            while(left < right && pivot > nums[left]) {
                left++;
            }
           if(left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        quickSort(nums, start, left-1);
        quickSort(nums, left + 1, end);
    }
}
// @lc code=end


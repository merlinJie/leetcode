/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (46.31%)
 * Likes:    437
 * Dislikes: 0
 * Total Accepted:    115.9K
 * Total Submissions: 247.3K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int aM = m - 1;
        int bM = n - 1;
        int cur = A.length - 1;
        while(bM >= 0) {
            if(aM < 0) {
                A[cur] = B[bM];
                bM--;
            } else if(B[bM] > A[aM]) {
                A[cur] = B[bM];
                bM--;
            } else {
                A[cur] = A[aM];
                aM--;
            }
            cur--;
        }
    }
}
// @lc code=end


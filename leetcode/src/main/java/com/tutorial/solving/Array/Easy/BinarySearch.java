/*
Problem:
    Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. 
    If `target` exists, then return its index. 
    Otherwise, return `-1`.
    You must write an algorithm with O(log n) runtime complexity.

Solution:
    - 
    -

Constraints:
    * 1 <= nums.length <= 104
    * -104 < nums[i], target < 104
    * All the integers in nums are unique.
    * nums is sorted in ascending order.

Testcase:
    Example 1:
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4
    
    Example 2:
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1

Complexity Analysis:
    - Time Complexity → O(log n)
    - Space Complexity → O(1)
    
 */

package com.tutorial.solving.Array.Easy;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    // Helper method to format array to string like [1,2,3,4]
    private static String formatArray(int[] nums) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        int[][] testCases = {
                { -1, 0, 3, 5, 9, 12 },
                { -1, 0, 3, 5, 9, 12 }
        };
        int[] target = { 9, 2 };

        for (int i = 0; i < testCases.length; i++) {
            int result = bs.search(testCases[i], target[i]);
            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: nums = " + formatArray(testCases[i]) + ", target = " + target[i]);
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}

/* 
Problem:
    Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

Solution:
    This is an easy problem so we can solve it easily. We can use two loops to solve like that:
    - First loop will iterate from 0 to len(nums)-1, i<-0
    - Second loop will iterate from i+1 to len(nums), j<-i+1
    - And we will check if nums[i] + nums[j] == target, then we will return the indices of i and j

Constraints:
    * 2 <= nums.length <= 104
    * -109 <= nums[i] <= 109
    * -109 <= target <= 109
    * Only one valid answer exists.

Testcase:
    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    
    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]

Complexity Analysis:
    - Time complexity: O(n^2)
    - Space complexity: O(1)

*/

package com.tutorial.solving.Array.Easy;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    // Helper method to format array like [2,7,11,15]
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
        TwoSum twoSum = new TwoSum();

        int[][] testCases = {
                { 2, 7, 11, 15 },
                { 3, 2, 4 },
                { 3, 3 }
        };
        int[] targets = { 9, 6, 6 };

        for (int k = 0; k < testCases.length; k++) {
            int[] result = twoSum.twoSum(testCases[k], targets[k]);
            System.out.println("Testcase " + (k + 1) + ":");
            System.out.println("Input: nums = " + formatArray(testCases[k]) + ", target = " + targets[k]);
            if (result.length > 0) {
                System.out.println("Output: [" + result[0] + "," + result[1] + "]");
            } else {
                System.out.println("Output: No solution found");
            }
            System.out.println();
        }
    }
}

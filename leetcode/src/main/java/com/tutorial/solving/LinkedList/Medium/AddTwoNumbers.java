/*
Problem:
    You are given two non-empty linked lists representing two non-negative integers. 
    The digits are stored in reverse order, and each of their nodes contains a single digit. 
    Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Solution:
    - 
    -

Constraints:
    * The number of nodes in each linked list is in the range [1, 100].
    * 0 <= Node.val <= 9
    * It is guaranteed that the list represents a number 
    that does not have leading zeros.

Testcase:
    Example 1:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Example 2:
    Input: l1 = [0], l2 = [0]
    Output: [0]

    Example 3:
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

Complexity Analysis:
    - Time Complexity: 
    - Space Complexity:

 */

package com.tutorial.solving.LinkedList.Medium;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        return dummy.next;
    }

    // Helper: Convert mảng thành danh sách liên kết
    private static ListNode arrayToList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper: Convert danh sách liên kết thành chuỗi
    private static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null)
                sb.append(",");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        int[][] l1Cases = {
                { 2, 4, 3 },
                { 0 },
                { 9, 9, 9, 9, 9, 9, 9 }
        };

        int[][] l2Cases = {
                { 5, 6, 4 },
                { 0 },
                { 9, 9, 9, 9 }
        };

        for (int i = 0; i < l1Cases.length; i++) {
            ListNode l1 = arrayToList(l1Cases[i]);
            ListNode l2 = arrayToList(l2Cases[i]);
            ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: l1 = " + listToString(l1) + ", l2 = " + listToString(l2));
            System.out.println("Output: " + listToString(result));
            System.out.println();
        }
    }
}

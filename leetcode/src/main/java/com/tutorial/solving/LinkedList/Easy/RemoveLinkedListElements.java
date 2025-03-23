/*
Problem:
    Given the `head` of a linked list and an integer `val`, 
    remove all the nodes of the linked list that has `Node.val == val`, and return the new head.

Solution:
    - 
    - 

Constraints:
    * The number of nodes in the list is in the range [0, 104].
    * 1 <= Node.val <= 50
    * 0 <= val <= 50

Testcase:
    Example 1:
    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]
    
    Example 2:
    Input: head = [], val = 1
    Output: []
    
    Example 3:
    Input: head = [7,7,7,7], val = 7
    Output: []

Complexity Analysis:
    - Time complexity: O()
    - Space complexity: O()

 */

package com.tutorial.solving.LinkedList.Easy;

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

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

    // Helper method to convert array to linked list
    private static ListNode arrayToList(int[] nums) {
        if (nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to convert linked list to string format
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
        RemoveLinkedListElements solution = new RemoveLinkedListElements();

        int[][] testCases = {
                { 1, 2, 6, 3, 4, 5, 6 },
                {},
                { 7, 7, 7, 7 }
        };

        int[] values = { 6, 1, 7 };

        for (int i = 0; i < testCases.length; i++) {
            ListNode head = arrayToList(testCases[i]);
            ListNode result = solution.removeElements(head, values[i]);

            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: head = " + listToString(arrayToList(testCases[i])) + ", val = " + values[i]);
            System.out.println("Output: " + listToString(result));
            System.out.println();
        }
    }
}

/*
Problem:
    You are given the `head` of a linked list.
    Remove every node which has a node with a greater value anywhere to the right side of it.
    Return the `head` of the modified linked list.

Solution:
    - 
    -

Constraints:
    * The number of the nodes in the given list is in the range [1, 105].
    * 1 <= Node.val <= 105

Testcase:
    Example 1:
    Input: head = [5,2,13,3,8]
    Output: [13,8]
    Explanation: The nodes that should be removed are 5, 2 and 3.
    - Node 13 is to the right of node 5.
    - Node 13 is to the right of node 2.
    - Node 8 is to the right of node 3.

    Example 2:
    Input: head = [1,1,1,1]
    Output: [1,1,1,1]
    Explanation: Every node has value 1, so no nodes are removed.

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

public class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        // First reverse the linked list
        head = reverseList(head);

        ListNode current = head;
        int max = current.val;

        ListNode result = current;
        ListNode prev = current;
        current = current.next;

        // Loop through the reversed linked list
        while (current != null) {
            if(current.val < max) {
                prev.next = current.next;
            } else {
                max = current.val;
                prev = current;
            }
            current = current.next;
        }

        // Do reverse again to get the original linked list
        return reverseList(result);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        RemoveNodesFromLinkedList solution = new RemoveNodesFromLinkedList();

        int[][] headTestCases = {
                { 5, 2, 13, 3, 8 },
                { 1, 1, 1, 1 }
        };

        for (int i = 0; i < headTestCases.length; i++) {
            ListNode head = createList(headTestCases[i]);

            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: head = " + listToString(head));

            ListNode removedNodeList = solution.removeNodes(head);
            System.out.println("Output: " + listToString(removedNodeList));
            System.out.println();
        }
    }

    private static ListNode createList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    private static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(",");
            }
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

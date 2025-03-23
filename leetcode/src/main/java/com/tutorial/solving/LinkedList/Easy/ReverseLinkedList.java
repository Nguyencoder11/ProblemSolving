/*
Problem:
    Given the head of a singly linked list, 
    reverse the list, and return the reversed list.

Solution:
    - 
    -

Constraints:
    * The number of nodes in the list is the range [0, 5000].
    * -5000 <= Node.val <= 5000

Testcase:
    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]
    
    Example 2:
    Input: head = [1,2]
    Output: [2,1]
    
    Example 3:
    Input: head = []
    Output: []

Complexity Analysis:
    - Time Complexity: 
    - Space Complexity:

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

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
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

    // Helper method to print a linked list in the required format.
    private static String formarList(ListNode head) {
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

    // Helper method to create a linked list from an array of integers.
    private static ListNode createList(int[] values) {
        if (values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 0; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        int[][] headTestCases = {
                { 1, 2, 3, 4, 5 },
                { 1, 2 },
                {}
        };

        for (int i = 0; i < headTestCases.length; i++) {
            ListNode head = createList(headTestCases[i]);

            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: head = " + formarList(head));

            ListNode reversedList = solution.reverseList(head);
            System.out.println("Output: " + formarList(reversedList));
            System.out.println();
        }
    }
}

/*
Problem:
    You are given the head of a linked list. 
    Delete the middle node, and return the head of the modified linked list.
    The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, 
    where ⌊x⌋ denotes the largest integer less than or equal to x.
    For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

Solution:
    -

Constraints:
    * The number of nodes in the list is in the range [1, 10^5].
    * 1 <= Node.val <= 10^5

Testcase:
    Example 1:
    Input: head = [1,3,4,7,1,2,6]
    Output: [1,3,4,1,2,6] 
    
    Example 2:
    Input: head = [1,2,3,4]
    Output: [1,2,4]
    
    Example 3:
    Input: head = [2,1]
    Output: [2]


Complexity Analysis:
    * Time complexity : 
    * Space complexity: 

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

public class DeleteTheMiddleNodeOfALinkedList {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // prev is the node before the middle node
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }

    private static String listToArray(ListNode head) {
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

    private static ListNode arrayToList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        DeleteTheMiddleNodeOfALinkedList solution = new DeleteTheMiddleNodeOfALinkedList();

        int[][] testCases = {
                { 1, 3, 4, 7, 1, 2, 6 },
                { 1, 2, 3, 4 },
                { 2, 1 }
        };

        for (int i = 0; i < testCases.length; i++) {
            ListNode head = arrayToList(testCases[i]);

            System.out.println("Testcase " + (i + 1) + ": ");
            System.out.println("Input: head = " + listToArray(head));

            ListNode result = solution.deleteMiddle(head);
            System.out.println("Output: " + listToArray(result));
            System.out.println();
        }
    }
}

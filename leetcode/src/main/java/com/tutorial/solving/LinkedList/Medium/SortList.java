/*
Problem:
    Given the `head` of a linked list, return the list after sorting it in ascending order.

Solution:
    -

Constraints:
    * The number of nodes in the list is in the range [0, 5 * 10^4].
    * -10^5 <= Node.val <= 10^5

Testcase:
    Example 1:
    Input: head = [4,2,1,3]
    Output: [1,2,3,4]
    
    Example 2:
    Input: head = [-1,5,3,4,0]
    Output: [-1,0,3,4,5]
    
    Example 3:
    Input: head = []
    Output: []

Complexity Analysis:
    * Time complexity : O(nlogn)
    * Space complexity: O(1)
    where n is the number of nodes in the linked list.

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

public class SortList {

    public ListNode sortList(ListNode head) {
        // If head is null or head has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        ListNode middle = findMiddle(head);
        ListNode left = head;
        ListNode right = middle.next;

        middle.next = null;

        // Sort the left and right halves
        left = sortList(left);
        right = sortList(right);

        return merge(left, right);

    }

    // Function to find the middle node of the linked list (Floyd's Tortoise and
    // Hare algorithm)
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Function to merge two sorted linked lists 'left' and 'right'
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if(left != null) {
            current.next = left;
        }

        if(right != null) {
            current.next = right;
        }

        return dummy.next;
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
        SortList sortList = new SortList();

        int[][] headTestCases = {
                { 4, 2, 1, 3 },
                { -1, 5, 3, 4, 0 },
                {}
        };

        for (int i = 0; i < headTestCases.length; i++) {
            ListNode head = arrayToList(headTestCases[i]);
            
            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: head = " + listToArray(head));
            ListNode sort = sortList.sortList(head);
            System.out.println("Output: " + listToArray(sort));
            
        }
    }
}

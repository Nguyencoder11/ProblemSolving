/*
Problem:
    You are given the heads of two sorted linked lists `list1` and `list2`.
    Merge the two lists into one sorted list. 
    The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.

Solution:
    - 
    - 

Constraints:
    * The number of nodes in both lists is in the range [0, 50].
    * -100 <= Node.val <= 100
    * Both list1 and list2 are sorted in non-decreasing order.

Testcase:
    Example 1:
    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]
    
    Example 2:
    Input: list1 = [], list2 = []
    Output: []
   
    Example 3:
    Input: list1 = [], list2 = [0]
    Output: [0]

Complexity Analysis:
    - Time complexity: O(m + n)
    - Space complexity: O(1)

 */

package com.tutorial.solving.LinkedList.Easy;

// Define for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null && list2 != null)
            return list2;
        if (list1 != null && list2 == null)
            return list1;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    // Helper method to create a linked list from an array
    private static ListNode createList(int[] values) {
        if (values.length == 0)
            return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print a linked list in the required format
    private static String formatList(ListNode head) {
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
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        int[][] testCasesList1 = {
                { 1, 2, 4 },
                {},
                {}
        };
        int[][] testCasesList2 = {
                { 1, 3, 4 },
                {},
                { 0 }
        };

        for (int i = 0; i < testCasesList1.length; i++) {
            ListNode list1 = createList(testCasesList1[i]);
            ListNode list2 = createList(testCasesList2[i]);

            System.out.println("Testcase " + (i + 1) + ":");
            System.out.println("Input: list1 = " + formatList(list1) + ", list2 = " + formatList(list2));

            ListNode result = solution.mergeTwoLists(list1, list2);
            System.out.println("Output: " + formatList(result));
            System.out.println();
        }
    }
}

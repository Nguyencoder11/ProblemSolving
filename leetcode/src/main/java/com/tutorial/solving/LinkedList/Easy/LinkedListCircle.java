/*
Problem:
    Given `head`, the head of a linked list, determine if the linked list has a cycle in it.
    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. 
    Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. 
    Note that `pos` is not passed as a parameter.
    Return `true` if there is a cycle in the linked list. Otherwise, return `false`.

Solution:
    - With this problem, we can use the Floyd's Tortoise and Hare (Cycle Detection) algorithm to solve it.
    - Use two pointers, `slow` and `fast`, to traverse the list.
    - `slow` moves one step at a time while `fast` moves two steps at a time.
    - If there is a cycle in the list, the `slow` and `fast` pointers will meet at some point.
    - If there is no cycle in the list, the `fast` pointer will reach the end of the list.
    - Return `true` if the `slow` and `fast` pointers meet, otherwise return `false`.

Constraints:
    * The number of the nodes in the list is in the range [0, 104].
    * -105 <= Node.val <= 105
    * pos is -1 or a valid index in the linked-list.

Testcase:
    Example 1:
    Input: head = [3,2,0,-4], pos = 1
    Output: true
    
    Example 2:
    Input: head = [1,2], pos = 0
    Output: true
    
    Example 3:
    Input: head = [1], pos = -1
    Output: false

Complexity Analysis:
    - Time Complexity: 
    - Space Complexity:

 */

package com.tutorial.solving.LinkedList.Easy;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCircle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move one step
            fast = fast.next.next; // Move two steps

            if (slow == fast) {
                return true; // has cycle
            }
        }

        return false; // no cycle
    }

    private static ListNode arrayToList(int[] arrs, int pos) {
        if (arrs.length == 0)
            return null;

        ListNode head = new ListNode(arrs[0]);
        ListNode current = head;
        ListNode cycleNode = null;

        if(pos == 0) {
            cycleNode = head;
        }

        for (int i = 1; i < arrs.length; i++) {
            current.next = new ListNode(arrs[i]);
            current = current.next;

            if (i == pos) {
                cycleNode = current;
            }
        }

        if (pos >= 0) {
            current.next = cycleNode;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListCircle solution = new LinkedListCircle();

        String[] headTestcases = {
                "[3,2,0,-4]",
                "[1,2]",
                "[1]"
        };
        int[] posTestcases = { 1, 0, -1 };

        for (int i = 0; i < headTestcases.length; i++) {
            String input = headTestcases[i].replaceAll("[\\[\\]]", "");  // remove '[' and ']'
            String[] split = input.split(",");
            int[] arr = new int[split.length];
            for (int j = 0; j < split.length; j++) {
                arr[j] = Integer.parseInt(split[j].trim());
            }

            ListNode head = arrayToList(arr, posTestcases[i]);

            System.out.println("Testcase " + (i + 1) + ":");
            boolean result = solution.hasCycle(head);
            System.out.println("Input: head = " + headTestcases[i] + ", pos = " + posTestcases[i]);
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}

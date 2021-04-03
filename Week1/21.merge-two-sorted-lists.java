/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(0);
        ListNode curr = mergedList;

        while (l1 != null && l2 != null) {
            curr.next = new ListNode(Math.min(l1.val, l2.val));
            curr = curr.next;

            if (l1.val < l2.val)
                l1 = l1.next;
            else
                l2 = l2.next;
        }

        curr.next = l1 == null ? l2 : l1;
        return mergedList.next;
    }
}
// @lc code=end


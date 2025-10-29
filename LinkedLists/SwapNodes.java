/**
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyHead = new ListNode (0);
        dummyHead.next = head;
        
        ListNode frontNode = null;
        ListNode endNode = null;
        ListNode currNode = head;
        int len = 0;
        while (currNode!=null){
            len++;
            if (endNode !=null) {
                endNode = endNode.next;
            }
            if (len == k){
                // keep the front and end nodes, k apart
                frontNode = currNode;
                endNode = head;
            }           

            currNode = currNode.next;
        }

        int tmp = frontNode.val;
        frontNode.val = endNode.val;
        endNode.val = tmp;

        return dummyHead.next;
    }
}

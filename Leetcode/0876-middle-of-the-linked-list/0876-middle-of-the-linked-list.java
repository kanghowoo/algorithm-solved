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

    List<ListNode> list = new ArrayList<>();

    public ListNode middleNode(ListNode head) {
        
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int idx = list.size() / 2;

        return list.get(idx);
    }

}
import pojo.ListNode;

public class MergeTwoLists {

    /**
     * 21. 合并两个有序链表
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null){
            head.next = l1;
        }
        return dummyNode.next;
    }
}

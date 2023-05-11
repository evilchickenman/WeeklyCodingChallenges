class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = (start + end) / 2;
        ListNode left = mergeLists(lists, start, mid);
        ListNode right = mergeLists(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example 1
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] lists1 = { node1, node2, node3 };

        Solution solution = new Solution();
        ListNode mergedList1 = solution.mergeKLists(lists1);
        printLinkedList(mergedList1);

        // Example 2
        ListNode[] lists2 = {};

        ListNode mergedList2 = solution.mergeKLists(lists2);
        printLinkedList(mergedList2);

        // Example 3
        ListNode[] lists3 = { null };

        ListNode mergedList3 = solution.mergeKLists(lists3);
        printLinkedList(mergedList3);
    }

    private static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        ListNode current = head;
        StringBuilder sb = new StringBuilder();

        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        System.out.println("[" + sb.toString() + "]");
    }
}

package com.ls;

public class ListUtils {
    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode generate(int[] arr) {
        ListNode dummy = new ListNode(0), next;
        ListNode cur = dummy;
        for (int i : arr) {
            next = new ListNode(i);
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        print(generate(new int[]{1,2,2,1}));
    }


}

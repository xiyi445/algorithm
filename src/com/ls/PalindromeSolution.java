package com.ls;

/**
 * 回文链表判断
 * 基本思路: 链表到中间节点后开始反转，然后新头结点和反转后头结点开始比对， 比对完成再对原链表反转
 * 奇数和偶数节点这里可以统一处理，方便很多
 * 偶数个数时， 如下，其中新的头节点先到达末尾，而原头结点没有到达，所以其中一个节点为空就停止，不用再往后比对
 * 1->2->2->1
 * 1->2->2<-1
 * <p>
 * 奇数个节点时，如下，心头结点和原头节点同时到达空
 * 1->2->1
 * 1->2<-1
 */
public class PalindromeSolution {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        boolean palindrome = true;
        ListNode slow = head, fast = head, newHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        newHead = reverseList(slow);
        fast = head;
        slow = newHead;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                palindrome = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        //恢复现场
        reverseList(newHead);
        return palindrome;
    }

    /**
     * 对链表反转
     *
     * @param head
     * @return 新的头结点
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, next, cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.generate(new int[]{1,2,3,4,2,1});
        System.out.println(isPalindrome(head));
        ListUtils.print(head);
    }
}

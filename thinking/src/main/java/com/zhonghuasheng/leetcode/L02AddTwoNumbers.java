package com.zhonghuasheng.leetcode;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class L02AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
/*        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;*/
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        ListNode result = addTwoNumbers(l1, l4);
        StringBuilder sb = new StringBuilder();
        sb.append(result.val);
        ListNode next = result.next;
        while(next != null){
            sb.append(" -> ");
            sb.append(next.val);
            next = next.next;
        }
        System.out.println(sb);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        ListNode tempX = l1, tempY = l2;

        // 需要带入下一位计算的值，只能是0和1
        int carry = 0;
        while (tempX != null || tempY != null) {
            int x = tempX == null ? 0 : tempX.val;
            int y = tempY == null ? 0 : tempY.val;
            int z = x + y + carry;
            result.val = z % 10;
            carry = z / 10;
            // 任何一个node有next都需要创建一个新的node
            if ((tempX != null && tempX.next != null) || (tempY != null && tempY.next != null)) {
                result.next = new ListNode(0);
                result = result.next;
            }
            if (tempX != null && tempX.next != null) {
                tempX = tempX.next;
            } else {
                tempX = null;
            }
            if (tempY != null && tempY.next != null) {
                tempY = tempY.next;
            } else {
                tempY = null;
            }
        }

        // 如果上次计算结束后carry为1，那么要新建node
        if (carry == 1) {
            result.next = new ListNode(1);
        }

        return curr;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

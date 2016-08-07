/**
 * Created by Atlantis on 16/4/25.
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1 && null == l2){
            return  null;
        }

        int forward = 0;
        ListNode ret = new ListNode(0);
        ListNode head = ret;
        while (null != l1 && null != l2){
            int sum = l1.val + l2.val +forward;
            forward = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            ret.next = new ListNode(sum%10);
            ret = ret.next;
        }
        while (null != l1){
            int sum = l1.val+forward;
            ret.next = new ListNode(sum%10);
            forward = sum/10;
            ret = ret.next;
            l1 = l1.next;
        }
        while (null != l2){
            int sum = l2.val+forward;
            ret.next = new ListNode(sum%10);
            forward = sum/10;
            ret = ret.next;
            l2 = l2.next;
        }
        if(forward != 0 ){
            ret.next = new ListNode(forward);
        }

        return head.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ret =addTwoNumbers(l1,l2);
        if(null != ret) {
            System.out.print(ret.val);
        }
        while (ret.next != null){
            System.out.print("->");
            System.out.print(ret.next.val);
            ret = ret.next;

        }
    }
}
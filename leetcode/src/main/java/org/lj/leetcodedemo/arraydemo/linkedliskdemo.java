package org.lj.leetcodedemo.arraydemo;

/**
 * 链表
 */
public class linkedliskdemo {
    /**
     * 19. 删除链表的倒数第N个节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res=new ListNode(0);
        ListNode curnode = res;
        ListNode l1cur=l1;
        ListNode l2cur=l2;
        int carry=0;
        while (l1cur!=null || l2cur!=null){
            int l1v = (l1cur!=null)?l1cur.val:0;
            int l2v = (l2cur!=null)?l2cur.val:0;

            int sum =carry+l1v+l2v;
            carry = sum / 10;
            curnode.next = new ListNode(sum % 10);
            curnode=curnode.next;

            if(l1cur!=null){
                l1cur=l1cur.next;
            }

            if(l2cur!=null){
                l2cur = l2cur.next;
            }
        }
        if(carry>0){
            curnode.next= new ListNode(carry);
        }

        return res.next;
    }

    /**
     *19. 删除链表的倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode removenode=null;
        ListNode removeparentnode=null;
        ListNode curnode = head;
        int diff =0;
        while(diff<n){
            if(curnode==null)
            {
                return head;
            }
            curnode=curnode.next;
            diff++;
        }
        removenode=head;
        if(curnode!=null){
            curnode=curnode.next;
            removenode=head.next;
            removeparentnode=head;
        }else {
            return head.next;
        }
        while (curnode!=null){
            curnode=curnode.next;
            removenode=removenode.next;
            removeparentnode=removeparentnode.next;
        }

        removeparentnode.next=removenode.next;
        return head;

    }

}

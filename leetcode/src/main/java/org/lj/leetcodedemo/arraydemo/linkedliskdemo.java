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

    /**
     * 21. 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return  null;
        }
        ListNode curnode_1 = l1;
        ListNode curnode_2 = l2;

        ListNode nlist=new ListNode(0);
        ListNode curnode_nlist =nlist;
        while(curnode_1!=null || curnode_2!=null){
            if(curnode_1==null){
                int curv=curnode_2.val;
                curnode_nlist.next=new ListNode(curv);
                curnode_nlist=curnode_nlist.next;
                curnode_2=curnode_2.next;
            }else if(curnode_2==null){
                int curv=curnode_1.val;
                curnode_nlist.next=new ListNode(curv);
                curnode_nlist=curnode_nlist.next;
                curnode_1=curnode_1.next;
            }else {
                int cur1=curnode_1.val;
                int cur2=curnode_2.val;
                if(cur1<=cur2){
                    curnode_nlist.next=new ListNode(cur1);
                    curnode_nlist=curnode_nlist.next;
                    curnode_1=curnode_1.next;
                }else {
                    curnode_nlist.next=new ListNode(cur2);
                    curnode_nlist=curnode_nlist.next;
                    curnode_2=curnode_2.next;
                }

            }
        }
        return  nlist.next;
    }

    /**
     * 24
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

    /**
     * 61. 旋转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    /**
     *83. 删除排序链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 82. 删除排序链表中的重复元素 II
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;

        while(b!=null && b.next!=null){
            if(a.next.val!=b.next.val){
                a=a.next;
                b=b.next;
            }
            else{
                while (b!=null && b.next!=null && a.next.val==b.next.val){
                    b=b.next;
                }
                a.next=b.next;
                b=b.next;
            }
        }



        return dummy.next;
    }
}

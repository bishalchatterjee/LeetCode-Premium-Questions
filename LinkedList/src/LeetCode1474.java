public class LeetCode1474 {
    //1474. Delete N Nodes After M Nodes of a Linked List

    static ListNode deleteNNodesAfterMNodes(ListNode head,int m,int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;

        while (temp != null && temp.next != null) {
            for (int i = 1; i <= m && temp != null && temp.next != null; i++) {
                temp = temp.next;
            }
            for (int i = 1; i <= n && temp != null && temp.next != null; i++) {
                temp.next = temp.next.next;
            }
        }
        return dummy.next;
    }

    static void printlist(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            if(head.next!=null) System.out.print("->");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        //LinkedList = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next=new ListNode(7);
        head.next.next.next.next.next.next.next=new ListNode(8);
        head.next.next.next.next.next.next.next.next=new ListNode(9);
        head.next.next.next.next.next.next.next.next.next=new ListNode(10);
        head.next.next.next.next.next.next.next.next.next.next=new ListNode(11);

        int m=1;
        int n=3;

        printlist(deleteNNodesAfterMNodes(head,m,n));
    }
}


//T.C-O(N)
//S.C-O(1)
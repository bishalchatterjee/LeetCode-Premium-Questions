class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val=val;
        next=null;
    }
}
public class LeetCode369 {
    //369. Plus One Linked List
    //Medium
    //https://www.lintcode.com/problem/plus-one-linked-list/solution/59394

    static ListNode plusOneLL(ListNode head){
        ListNode dummy=new ListNode(0); // dummy to handle all 9's
        dummy.next=head;
        ListNode nonNine=dummy; //imp to handle 9->9->9

        while(head!=null){ // find the rightmost not-nine digit
            if(head.val!=9) nonNine=head;
            head=head.next;
        }

        nonNine.val++; // increase this rightmost not-nine digit by 1
        nonNine=nonNine.next;

        while(nonNine!=null){ // set all the following nines to zeros
            nonNine.val=0;
            nonNine=nonNine.next;
        }

        return dummy.val!=0 ? dummy : dummy.next;
    }

    static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            if(head.next!=null) System.out.print(" -> ");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(9);
        head.next=new ListNode(9);
        head.next.next=new ListNode(9);

        ListNode res=plusOneLL(head);
        printList(res);

    }
}


//T.C -> O(n)
//S.C -> O(1)
package hubspot.dsa;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    ListNode(int val) {
        this.val = val;
    }
}
public class MergeTwoSortedList {

    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {

        // start with new node as negative
        ListNode result = new ListNode(-1);
        // head will be use to return as the result for linked list
        ListNode head = result;


        while(list1 != null && list2 !=null){
            // since the list1 val is less we add it in result
            if(list1.val <= list2.val ){
                result.next = list1;
                list1 = list1.next;
            }else{
                // list 2 val is less add it in result
                result.next = list2;
                list2 = list2.next;
            }
            // dont forget to move result to next
            result = result.next;
        }
        // if there are more elements present in any of the list we append that in result
        if(list1 == null ){
            result.next = list2;
        }else{
            result.next = list1;
        }
        // this is important since result is pointing to negative value
        return head.next;
    }

    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if(list1 == null){
            return  list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            // lis1 is small we will compare list1.next with list 2
            list1.next = mergeTwoListsRecursive(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoListsRecursive(list1,list2.next);
            return list2;
        }

    }

        public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList =  new MergeTwoSortedList();

    }
}


package easy;

class SollutionMergeTwoSortedList{
    public static void main(String[] args) {
        // MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        System.out.println("Merging two sorted list");
    }
}


 // Definition for singly-linked list.
class ListNode {
    int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = new ListNode(-1);
        ListNode result= current;
        while(list1 != null && list2 != null){
            if(list1.val >list2.val){
                current.next = list2;
                list2= list2.next;
            }
            else{
                current.next = list1;
                list1 = list1.next;
            }
            System.out.println(current.val);
            current = current.next; 
        }
        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }   

        return result.next;
    }
}
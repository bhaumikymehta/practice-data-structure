package easy;

class SollutionMergeTwoSortedList{
    public static void main(String[] args) {
        // MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        System.out.println("Merging two sorted list");
    }
}


 // Definition for singly-linked list.
class ListNode2 {
    int val;
     ListNode2 next;
     ListNode2() {}
    ListNode2(int val) { this.val = val; }
     ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
 }

class MergeTwoSortedList {
    public ListNode2 mergeTwoLists(ListNode2 list1, ListNode2 list2) {
        ListNode2 current = new ListNode2(-1);
        ListNode2 result= current;
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
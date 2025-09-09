class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode node = new ListNode();
        var head = node;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            }
            else if(list1.val > list2.val){
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        head.next = (list1 == null)? list2 : list1;

        return node.next;
    }
}
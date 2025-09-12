class Solution {
    public ListNode reverseList(ListNode head) {

        List<Integer> list = new ArrayList<>();

        ListNode node = new ListNode();
        var point = node;

        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        for(int i=list.size()-1; i>=0; i--){
            point.next = new ListNode(list.get(i));
            point = point.next;
        }

        return node.next;
    }
}
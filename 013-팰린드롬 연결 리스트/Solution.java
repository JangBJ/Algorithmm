class Solution {
    public boolean isPalindrome(ListNode head) {

        List<Integer> p = new ArrayList<>();

        while(head != null){
            p.add(head.val);
            head = head.next;
        }

        var ll = 0;
        var rl = p.size()-1;

        while(ll<rl){
            if(p.get(ll) == p.get(rl)) {
                ll++;
                rl--;
            }
            else return false;
        }
        return true;
    }
}
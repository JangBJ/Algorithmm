# 팰린드롬 연결 리스트
리스트 노드 객체가 팰린드롬인지 판단하는 문제

## 풀이
1. ListNode 객체를 하나하나씩 List에 담습니다.
2. 담은 후 반복을 통해 양쪽에서 팰린드롬인지 비교합니다.

## 풀이 코드
```java
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
```
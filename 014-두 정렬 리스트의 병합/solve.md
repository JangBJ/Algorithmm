# 두 정렬 리스트의 병합
정렬된 두 연결리스트가 있습니다.  
해당 리스트 두 개를 정렬된 순서로 하나의 연결 리스트로 만들어줍니다.

## 풀이
1. 더미 ListNode 객체를 생성해줍니다.
   1. 해당 객체만 사용한다면 처음 시작 지점을 모르게됩니다.
   2. 그래서 head라는 포인터를 생성해줘 포인터를 움직입니다.
2. 반복은 주어지는 두 ListNode 객체가 null이 아닐시에만 진행합니다.
   1. head 포인터를 움직여가며 정렬된 채로 연결 시켜줍니다.
   2. 조건문이 종료된다면 head의 위치를 head.next로 옮겨줍니다.
3. 만약 반복문이 종료됐다면 둘 중 하나는 null이라는 소리입니다.
   1. 나머지 하나의 ListNode를 연결시켜줍니다. (둘다 null이라도 상관하지 않습니다.)
4. 더미 ListNode의 next를 보여줍니다.

## 풀이 코드
```java
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
```
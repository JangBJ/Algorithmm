# 역순 연결 리스트I
주어진 ListNode를 역순으로 만듭니다.


# 풀이
1. 주어진 ListNode를 List에 넣어줍니다.
2. 역순으로 빼서 LisstNode를 만들고 연결시켜줍니다.

## 풀이 코드
```java
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
```

## 개선  풀이
1.  굳이 List에 넣을 필요가 없다.
2. ListNode를 주고 

## 개선 코드
```java


```
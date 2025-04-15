# 문자열 뒤집기

## 풀이 해법
1. 문자열 뒤집기란? 양 끝을 쪼여오면서 해당 문자들을 바꿔주면된다

해당 문자 배열이 주어졌을때 배열의 끝까지 가는 반복 하는 것이 아닌 `절반`만 반복하면 된다.

```java
class Solution {
    public void reverseString(char[] s) {
        int l = s.length;
        int len = s.length/2;

        for(int i=0; i<len; i++){
            char tmp = s[l-(i+1)];
            s[l-(i+1)] = s[i];
            s[i] = tmp;
        }
    }
}
```
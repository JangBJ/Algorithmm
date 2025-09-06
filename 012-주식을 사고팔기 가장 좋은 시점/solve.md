# 주식을 사고팔기 가장 좋은 시점
가장 큰 이득을 볼수 있는 이득이 몇인지 구하는 문제입니다.

## 풀이
1. 배열을 순차적으로 순환한다.
   1. 최솟값을 찾는다.
      1. `Math.min()`을 사용해 현재 최솟값과 배열의 값을 비교해 최솟값을 찾는다. 
   2. 결과값을 얻기위해 현재 결과값에 저장된 값과 현재배열의 값 - 최솟값을 비교한다.
      1. `Math.max()`를 이용해 결과값을 저장한다.

## 풀이 코드
```java
class Solution {
    public int maxProfit(int[] prices) {
        
        var min = Integer.MAX_VALUE;
        var res = 0;

        for(int i=0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i]-min);
        }

        return res;
    }
}
```
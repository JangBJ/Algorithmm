# 자신을 제외한 배열의 곱
배열이 주어지고 해당 자릿수의 배열을 제외한 나머지 수의 곱을 구합니다.  
단, 나눗셈은 금지한다.


# 풀이
1. 반복을 진행합니다
    1. 이중 for 문을 이용해 해당 배열번째는 제외합니다.

## 풀이 답
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] res = new int[nums.length];
    
        for(int i=0; i < nums.length; i++){
            var mul = 1;
            for(int j=0; j < nums.length; j++){
                if(i==j) continue;
                else mul *= nums[j];
            }
            res[i] = mul;  
        }
        return res;
    }
}
```

위는 이중 for문의 사용으로 O(n^2)이기에 time error가 납니다.

## 개선된 풀이
1. 왼쪽부터 시작되게 배열의 곱과 해당 배열의 곱에서 주어진 배열을 오른쪽에서 다시 곱해준다 그렇게하면 O(n)을 유지하게된다

## 개선된 풀이 답
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] res = new int[nums.length];
    
        var p = 1;
        for(int i=0; i < nums.length; i++){
            res[i] = p;
            p *= nums[i];
        }
        
        p = 1;
        for(int i = nums.length-1; i>=0; i--){
            res[i] *= p;
            p *= nums[i];
        }
        return res;
    }
}
```
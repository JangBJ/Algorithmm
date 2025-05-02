# 두 수의 합
배열과 결과값을 제공해줍니다  
해당 배열을 순회하며 두 수의 합이 결과값이 되는 배열의 인덱스를 구해줍니다

## 조건
같은 인덱스에 위치한 값이 더해지는 것은 결과에 해당하지 않습니다

## 풀이
1. 2중 for문을 이용해 순차적으로 순회하며 결과를 조회합니다

## 풀이 코드
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        var res = new int[2];

        for(int i=0; i<nums.length; i++){
            for(int j=1; j<nums.length; j++){
                if(j==i) continue;
                else if(nums[i]+nums[j]==target){
                    res[0] = i; 
                    res[1] = j; 
                    break;
                }
            }
        }
        return res;
    }
}
```
위 코드의 성능은 상당히 좋지 않습니다 O(n^2)의 시간이 걸리게 됩니다


## 개선 풀이
1. 2중 for문을 도는것은 좋은 선택이 아니었습니다
2. `간단한 해결법`은 배열의 첫 요소를 뺀것을 기준으로 순차하며 뺀 결과에서 다시 배열의 원소를 빼 0이 되는 값을 찾으면 됩니다
3. 먼저 `Map`을 만들어주고
4. `for`문을 통해 value를 설정해줍니다
5. value는 처음에 무조건 null이되고 map의 값을 저장(key: 값, value: 인덱스)시킵니다
6. 순회하며 value의 값이 0이 된다면 저장하는 되었던 값이 나올것이고 이 값이 정답이 될것입니다

## 개선 코드
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        var res = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){
            var value = res.get(target - nums[i]);
            if(value != null) return new int[]{i, value};
            else res.put(nums[i], i);
        }
        return null;
    }
}
```
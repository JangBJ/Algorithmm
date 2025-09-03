# 배열 파티션1
배열을 2개씩 파티셔닝하여 각 파니셔닝된 부분중 작은값들의 합이 최대치가 되는 것을 구하는 것

# 풀이
1. 정렬
2. `Math`클래스를 이용해 min( )사용

```java
class Solution {
    public int arrayPairSum(int[] nums) {
        
        Arrays.sort(nums);
        var sum = 0;

        for(int i=0; i <= nums.length-1; i+= 2){
            var j = i+1;

            sum += Math.min(nums[i], nums[j]);
        }
        return sum;
    }
}
```

개선된 풀이
```java
class Solution {
    public int arrayPairSum(int[] nums) {
        
        Arrays.sort(nums);
        var sum = 0;

        for(int i=0; i <= nums.length-1; i+= 2){
            sum += nums[i];
        }

        return sum;
    }
}
```

1. 굳이 min을 사용할 필요는 없었다
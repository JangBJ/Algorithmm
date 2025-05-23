# 빗물 트래핑
주어진 배열 만큼의 언덕이 있다  
해당 언덕 아래 빗물이 새지않고 그대로 고인다고 할때 얼마만큼의 빗물이 모이는가를 구하라

## 풀이
1. 주어진 배열에서 제일 먼저 나오는 양수 값을 구한다
2. 그 다음 탐색에서 해당 양수 값과 같거나 큰 값이 나오면 탐색을 그만한다
   1. 이때 조건이 존재한다
   2. 얻은 양수 값과 같거나 큰값이 바로 다음에 나온다면 빗물은 고이지 않는다
3. 위 조건을 만족해서 탐색이 그만될시 count를 이용해 얼마만큼 갔는지 구하고 해당 양수값과 곱한다
4. 그 후 지나온 언덕의 크기만큼을 빼주고 res에 저장한다
5. 위 를 반복한다
   1. 반복시 주의할 점이 있다 자신보다 작은 언덕만 나와 빗물이 고이지 않는다고 생각하지만
   2. 그 뒤의 언덕에서 고일수도 있다
   3. 이때는 해당 언덕 뒤에서 다시 반복을 수행하게한다

## 풀이 코드
```java
class Solution {
   public int trap(int[] height) {

      var tmp = 0;
      var cnt = 0;
      var res = 0;
      var last = height.length-2;
      var a = 0;

      for(int i=0; i<height.length; i++){

         if(height[i]>0 && tmp == 0){
            tmp = height[i];
            cnt = i;
         }

         else if(i-cnt == 1 || height[i]==0) continue;

         else if(height[i]>=tmp) {
            res += (i-cnt+1) * tmp - (tmp*2+a);
            tmp = height[i];
            cnt = i;
         }

         else if(tmp>height[i]) a += height[i];

         else if(i==height.length-1 && cnt != height.length-1){
            i = cnt + 1;
            tmp = height[i];
            cnt = i;
         }

         else if(cnt == last && tmp == height[last] || cnt==last+1 && tmp == height[last+1]) break;
         else break;
      }
      return res;
   }
}
}
```

## 다른 풀이
1. 제일 큰 값을 찾는다
   1. 그 큰값이 배열의 첫 요소나 끝 요소인지 찾는다
   2. 만약 맞다면 (큰요소 - 그다음 작은 요소) * 요소 간 인덱스차이
2. 제일 큰 값 * 배열의 길이를 구하고 위에서 찾은 값들과 배열의 총 합을 빼준다.


## 개선 풀이
1. 시간 복잡도를 위해 투 포인터를 사용합니다
2. 양 끝에서 고여있는 물의 양을 더하면서 가장 높은 크기의 막대를 찾아갑니다

```java
class Solution {
    public int trap(int[] height) {
        var size = height.length;
        var sum = 0;
        var ll = 0;
        var rl = size - 1;
        var lmax = height[0];
        var rmax = height[rl];

        while(ll <= rl) {
            if(lmax <= rmax) {
                lmax = Math.max(lmax, height[ll]);
                sum += lmax - height[ll++];
            }else {
                rmax = Math.max(rmax, height[rl ]);
                sum += rmax - height[rl--];
            }
        }

        return sum;
    }
}
```
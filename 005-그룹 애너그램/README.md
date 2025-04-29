# 그룹 애너그램  
주어진 문자열에서 애너그램인것들끼리 배열로 묶어서 적은 개수의 배열부터 출력시키기

## 🤔 애너그램이란?  
어떤 단어를 재배열시켜 다른 뜻을 가진 단어로 만드는 것을 의미한다

## 문제 풀이
1. 주어진 배열의 문자열을 정렬시키기 위해서 `toCharArray`를 이용해 문자 배열로 만든다
2. 그 후 `sort`를 이용해 정렬 시킨뒤
3. 해당 값을 key로 만든다
4. `if`문에서 `containsKey`를 이용해 해당 키 값을 조회한 후 없으면 Map안에 새로운 key, ArrayList<>를 생성한다
5. 만약 키가 있다면 그냥 값만 넣어준다
6. 해당 반환타입이 List이기에 `return`문에서 Map.values()를 사용해 List를 만들어서 반환해준다 

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();
        // 배열안의 문자열을 모두 알파벳 순으로 정렬하기
        // 같은 것을 List로묶기
        for(var str:strs){
            var ch = str.toCharArray();
            Arrays.sort(ch);

            var key = String.valueOf(ch);

            if(!res.containsKey(key)){
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
```
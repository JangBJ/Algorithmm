# 가장 긴 팰린드롬 부분 문자열 🔠
주어진 문자열에서 팰린드롬을 찾는다  
조건은 주어진 문자열에서 가장 길이가 긴 팰린드롬을 찾는것

# 🙈 내 생각 풀이
1. 배열의 처음부터 가장 멀리있는 같은 문자를 찾는다
2. 일치하는 문자를 찾으면 해당 문자부터 점점 안으로 좁혀와서 비교하기
3. 만약 비교하는 도중 팰린드롬이 아니라면 그 다음 일치 문자를 찾아서 반복
4. 만약 첫 문자가 아니라면 그다음 문자를 이용해서 2,3,4풀이 반복

풀이 코드(미완성)
```java
class Solution {
    public String longestPalindrome(String s) {

        String res = "";
        var ll = 0;
        var rl = s.length();

        while(true){
            if(s.charAt(ll) == s.charAt(rl)){
                ll++;
                rl--;
                res += s.charAt(ll);
            }
            else if(s.charAt(ll) != s.charAt(rl)) rl--;
            else if(ll==rl) res += s.charAt(ll);
            return res;
        }
    }
}
```

# 📖 해답 풀이
1. 주어진 문자열의 길이가 0 또는 1인 경우에는 비교를 하지 않아도 되기에 바로 `return`해줍니다
2. 가장 긴 팰린드롬을 찾기 위한 조건은 해당 앞서 찾은 팰린드롬 보다 길거나 만약 길이가 동일할시 문자열에서 앞서있는 팰린드롬이 답이 됩니다
3. 해당 문자열이 팰린드롬이 아닌 경우 앞 앞 문자라도 있어야하기에 해당 기본값으로 맨 첫문자를 지정해 놓습니다 -> 이후 길이가 긴 문자열이 온다면 자연스럽게 교체됩니다
4. 한 문자열을 다 돌기 때문에 1번의 `for`문과 for문 내에 2가지의 if문을 사용합니다
5. `if`문의 조건은 유효한 팰린드롬의 길이가 `짝수`일수도 `홀수`일수도 있기 때문입니다
6. "bb"인 경우도 유효한 팰린드롬 "bcb"도 유효한 팰린드롬 이기 때문입니다
7. 점차 범위를 넓혀가며 찾은 팰린드롬의 길이가 더 길다면 해당 팰린드롬으로 교체합니다
```java
class Solution {
    public String longestPalindrome(String s) {
        int size = s.length();

        // 주어진 문자열의 길이가 없거나 1인경우 그냥 해당 문자열을 반환합니다
        if(size==0||size==1) return s;

        // 만약 팰린드롬이 아닌경우 맨 앞 문자 출력
        // 이후 팰린드롬 나올 길이에 의해 변경됨
        String res = ""+s.charAt(0);

        for(int i=0; i<size; i++){
            if(i<size-1 && s.charAt(i)==s.charAt(i+1)){
                int start = i;
                int end = i+1;

                while(start>=0 && end<size&&s.charAt(start)==s.charAt(end)){
                    String tmp = s.substring(start, end+1);

                    if(tmp.length()>res.length()){
                        res = tmp;
                    }
                    start--;
                    end++;
                }
            }

            if(i<size-2 && s.charAt(i)==s.charAt(i+2)){
                int start = i;
                int end = i+2;

                while(start>=0 && end<size&&s.charAt(start)==s.charAt(end)){
                    String tmp = s.substring(start, end+1);

                    if(tmp.length()>res.length()){
                        res = tmp;
                    }
                    start--;
                    end++;
                }
            }
        }
        return res;
    }
}
```
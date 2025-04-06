## 유효한 팰린드롬 문제
1. 문자열 데칼코마니 문제
2. 알파벳이 아닌 모든 문자는 무시

- `Character.isLetterOrDigit`

    파라미터의 char 값이 `문자 혹은 숫자 인지 여부를 판단`하여 true/false를 반환
    
- `Character.toLowerCase`
    
    입력받은 인자 값을 소문자로 변환해줌

이 문제는 투 포인터를 활용하면 좋다고 한다 그래서 풀어 보겠다.

```java
public boolean isPalindrome(String s) {
        // 소문자로 바꾸기
        s = s.toLowerCase();
        
        // 시작 포인터
        int ll=0;
        // 반대편 시작 포인터
        int rl=s.length()-1;

        while (ll<=rl){
           
            char l = s.charAt(ll);
            char r = s.charAt(rl);
            // 숫자인지 문자인지 확인 숫자면 넘어가기 위해 
            if(!Character.isLetterOrDigit(l)) ll++;
            else if(!Character.isLetterOrDigit(r)) rl--;
            else if(l == r){ // 문자 비교
                ll++;
                rl--;
            }
            else return false;
        }
        return true;
    }
```

🤔 이것은 77%의 결과가 나왔다.  
이유는 불필요한 소문자 바꿈 떄문임
나는 시작부터 소문자로 모두 바꾸어 비교하기 때문에 불필요한 작업한것임  
`else if`을 추가해서 `toLowerCase`해주기

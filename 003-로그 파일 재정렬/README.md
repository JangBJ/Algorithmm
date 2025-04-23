# 문자열 배열 정렬
1. letter로그, digit로그 순으로 먼저 정렬한다
2. digit 로그는 배열 순서로 정렬된다
3. letter로그는 식별자 뒤 문자열부터 비교
4. 만약 모두 일치한다면 마지막으로 식별자 비교

- `Character.isAlphabetic`
    문자인지 구분해줌

```java
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        int len = logs.length-1;

        for(int i=logs.length-1; i>=0; i--){

            String[] str = logs[i].split(" ");

            if('0'<=str[1].charAt(0) && str[1].charAt(0)<= '9'){
                String tmp = logs[len];
                logs[len] = logs[i];
                logs[i] = tmp;
                len--;
            }
        }

        for(int i=0; i<=len; i++){
            
            for(int j=i+1; j<=len; j++){
                
                String[] a = logs[i].split(" ");
                String[] b = logs[j].split(" ");

                int min = Integer.MAX_VALUE;
                if(a.length>=b.length) min = b.length;
                else min = a.length;

                int k = 1;
                while(k < min){
                    if(!a[k].equals(b[k])){
                        if(a[k].compareTo(b[k]) > 0){
                            String tmp = logs[i];
                            logs[i] = logs[j];
                            logs[j] = tmp;
                        }
                        break;
                    }
                    k++;
                }
                if(k==min){
                    if(a.length != b.length){
                        if(a.length>b.length){
                            String tmp = logs[i];
                            logs[i] = logs[j];
                            logs[j] = tmp;
                        }
                    }
                    else {
                        if(a[0].compareTo(b[0]) > 0){
                            String tmp = logs[i];
                            logs[i] = logs[j];
                            logs[j] = tmp;
                        }
                    }
                }
            }
        }
        return logs;
    }
}
```

개선 코드
```java
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // 각각의 배열을 만듬
        var letterLists = new ArrayList<String>();
        var digitLists = new ArrayList<String>();

        // 문자인지 숫자인지 구분해서 각 로그 배열에 넣어줌
        for(var log: logs) {
            if(Character.isAlphabetic(log.charAt(log.indexOf(" ") + 1))) letterLists.add(log);
            else digitLists.add(log);
        }

        // 사전순으로 정렬
        Collections.sort(letterLists, (s1, s2) -> {
            var t1 = s1.split(" ", 2);
            var t2 = s2.split(" ", 2);

            var compare = t1[1].compareTo(t2[1]);

            if(compare == 0) {
                return t1[0].compareTo(t2[0]);
            }

            return compare;
        });

        // 마지막에 디지트 로그 다 넣어주기
        letterLists.addAll(digitLists);
        return letterLists.toArray(String[]::new);
    }
}

```
    
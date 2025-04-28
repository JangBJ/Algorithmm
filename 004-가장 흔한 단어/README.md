# 가장 흔한 단어 
1. 문자열 배열과 금지 단어가 주어진다
2. 문자열의 해당 단어를 분할? 해서 cnt 해준다
3. 많이 나온단어가 금지단어인지 비교후 맞으면 다음 출력, 아니면 현재 출력

```java
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
         
        paragraph = paragraph.replaceAll("[^a-zA-Z ]", " ");
        paragraph = paragraph.toLowerCase();

        int best = -1;
        int b = 0;
        List<Integer> cnt = new ArrayList<Integer>();
        List<String> str = new ArrayList<String>();

        String[] check = paragraph.split(" ");

        for(int i=0; i<check.length; i++){
            
            if (check[i].isEmpty()) continue;

            boolean found = false;

            for (int j = 0; j < str.size(); j++) {
                if (str.get(j).equals(check[i])) {
                    cnt.set(j, cnt.get(j) + 1);
                    found = true;
                    break;
                }
            }

            if (!found) {
                str.add(check[i]);
                cnt.add(1);
            }
        }

        for (int i = 0; i < str.size(); i++) {

            boolean isBanned = false;

            for (int j = 0; j < banned.length; j++) {
                if (str.get(i).equals(banned[j])) {
                    isBanned = true;
                    break;
                }
            }

            if (!isBanned && cnt.get(i) > best) {
                best = cnt.get(i);
                b = i;
            }
        }
        return str.get(b);
    }
}
```

공부할 풀이 과정

```java
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();

        for (var text : paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ")) {
            if (bannedSet.contains(text)) continue;

            count.put(text, count.getOrDefault(text, 0) + 1);
        }

        return count.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .limit(1)
                .map((e) -> e.getKey())
                .findFirst()
                .orElse(" ");
    }
}
```

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
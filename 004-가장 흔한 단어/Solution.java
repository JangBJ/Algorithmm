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
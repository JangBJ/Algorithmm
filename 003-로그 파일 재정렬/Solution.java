class Solution {
    public String[] reorderLogFiles(String[] logs) {
        var letterLists = new ArrayList<String>();
        var digitLists = new ArrayList<String>();

        for(var log: logs) {
            if(Character.isAlphabetic(log.charAt(log.indexOf(" ") + 1))) letterLists.add(log);
            else digitLists.add(log);
        }

        Collections.sort(letterLists, (s1, s2) -> {
            var t1 = s1.split(" ", 2);
            var t2 = s2.split(" ", 2);

            var compare = t1[1].compareTo(t2[1]);

            if(compare == 0) {
                return t1[0].compareTo(t2[0]);
            }

            return compare;
        });

        letterLists.addAll(digitLists);
        return letterLists.toArray(String[]::new);
    }
}

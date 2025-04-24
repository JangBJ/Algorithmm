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
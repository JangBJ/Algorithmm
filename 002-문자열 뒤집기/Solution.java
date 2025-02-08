class Solution {
    public void reverseString(char[] s) {
        int l = s.length;
        int len = s.length/2;

        for(int i=0; i<len; i++){
            char tmp = s[l-(i+1)];
            s[l-(i+1)] = s[i];
            s[i] = tmp;
        }
    }
}
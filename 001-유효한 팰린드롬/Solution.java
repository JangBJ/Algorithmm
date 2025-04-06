class Solution {
    public boolean isPalindrome(String s) {

        int ll=0;
        int rl=s.length()-1;

        while (ll<=rl){
            char l = s.charAt(ll);
            char r = s.charAt(rl);

            if(!Character.isLetterOrDigit(l)) ll++;
            else if(!Character.isLetterOrDigit(r)) rl--;
            else if(Character.toLowerCase(l)==Character.toLowerCase(r)){
                ll++;
                rl--;
            }
            else return false;
        }
        return true;
    }
}
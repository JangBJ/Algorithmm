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
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts){
        int n = friends.length;

        Map <String, Integer> idx = new HashMap<>();
        //key로는 사람의 이름을, 그리고 value로는 순차적인 번호를 부여합니다.
        for(int i = 0; i < n; i++){ idx.put(friends[i], i);}

        // 선물을 준 횟수를 기록하는 배열
        int[][] cnt = new int[n][n];
        // 위에 2차원 배열이 있는데도 불구하고 배열을 다시 만든 이유는 선물지수를 구하기 위함입니다.
        int[] given = new int[n];
        int[] received = new int[n];

        // gifts 기반을 이용해 해당 선물을 주고 받은 개수를 만듭니다.
        for(String s : gifts){
            // 공백 기준으로 해당 인원들이 주어지기에 분리해줍니다.
            String[] p = g.split(" ");
            // 한번에 주어지는게 두명이기에 해당 이름을 넣고 처음에 순차적으로 부여받은 value를 받습니다.
            int a = idx.get(p[0]);
            int b = idx.get(p[1]);
            // a순번을 받은 인원이 b순번을 받은 인원에게 선물을 줬다고 표기해줍니다.
            cnt[a][b]++;
            // a가 선물을 줬기 떄문에 준 횟수를 더해줍니다
            given[a]++;
            received[b]++;
        }

        // 선물 지수
        int[] giftIndex = new int[n];

        // 선물 지수 구하기
        for(int i=0; i<n; i++){
            giftIndex[i] = given[i] - received[i];
        }

        // 다음달 받을 선물 개수 집계
        int[] nextMonthGet = new int[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(cnt[i][j] > cnt[j][i]){
                    nextMonthGet[i]++;
                }
                else if(cnt[i][j] < cnt[j][i]){
                    nextMonthGet[j]++;
                }
                // 기록이 없거나 같은 경우 선물 지수 비교
                else {
                    if(giftIndex[i] > giftIndex[j]){
                        nextMonthGet[i]++;
                    }
                    else if(giftIndex[i] <giftIndex[j]){
                        nextMonthGet[j]++;
                    }
                }
            }

            int res = 0;
            for(int x : nextMonthGet){
                ans = Math.max(ans, x);
            }
            retrun ans;
        }
    }
}
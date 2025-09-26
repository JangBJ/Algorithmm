class Solution {
    public int[] solution(int[][] edges) {
        // 최대값 상수 선언
        final int MAX = 1_000_000;

        int[] in = new int[MAX + 1];
        int[] out = new int[MAX + 1];

        int maxNode = 0;

        // 주어진 간선들 분석해 생성 정점의 in, out의 수 누적
        for(int[]e : edges){
            out[e[0]]++;
            in[e[1]]++;
            if(e[0] > maxNode) maxNode = e[0];
            if(e[1] > maxNode) maxNode = e[1];
        }

        // 생성 정점 찾기
        int gen = 0;
        for(int i=1; i<=maxNode; i++){
            if(in[i] == 0 && out[i] >= 2){
                gen = i;
                break;
            }
        }

        // 막대, 8자 개수 구하기
        int stick = 0, eight = 0;
        for(int i = 1; i<maxNode; i++){
            if(i==gen) continue;
            if(out[i] == 0 && in[i] > 0) stick++;
            if(out[i] >= 2 && in[i] >= 1) eight++;
        }

        int donut = out[gen] - stick - eight;
        return new int[]{gen, donut, stick, eight};
    }
}
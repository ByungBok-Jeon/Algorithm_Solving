
/* Lv2. 땅따먹기
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/12913
 * 프로그래머스 문제
 */
public class Solution_PR_Lv2_땅따먹기 {
	int solution(int[][] land) {
        int ans = 0;
		int[] scores = land[0];
		for (int i = 1; i < land.length; i++) {
			int[] tmpScores = land[i];
			for (int j = 0; j < 4; j++) {
				int max = 0;
				for (int k = 0; k < 4; k++) {
					if(j==k) continue;
					if(tmpScores[j]+scores[k]>max) {
						max = tmpScores[j]+scores[k];
					}
				}
				tmpScores[j] = max;
			}
			scores = tmpScores;
		}
		for (int i = 0; i < 4; i++) {
			ans = Math.max(ans, scores[i]);
		}
        return ans;
	}
}

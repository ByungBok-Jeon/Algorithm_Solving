
/* 13300번 방배정
 * 출처 : https://www.acmicpc.net/problem/13300
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_13300_방배정 {
	static int N;// 학생 수
	static int K;// 방 최대인원
	static int[][] map;// 학년, 성별 저장

	public static void main(String[] args) throws Exception {
		int ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[7][2];// 0 인덱스 사용안함
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			map[grade][gender]++;
		}
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				while (map[i][j] > 0) {
					ans++;
					map[i][j] -= K;
				}
			}
		}
		System.out.println(ans);
	}
}


/* 12015번 가장 긴 증가하는 부분수열2
 * 출처 : https://www.acmicpc.net/problem/12015
 * Baekjoon Online Judge  문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_12015_가장긴증가하는부분수열2 {
	
	static int N;
	static int[] arr;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		p = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(p, 1);
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i] && p[j]+1 > p[i]) {
					p[i] = p[j]+1;
				}
			}
			max = Math.max(max, p[i]);
		}
		System.out.println(max);
	}
}

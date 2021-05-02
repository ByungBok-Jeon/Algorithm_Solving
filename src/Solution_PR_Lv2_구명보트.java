
/* Lv2. 구명보트
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42885
 * 프로그래머스 문제
 */
import java.util.Arrays;

public class Solution_PR_Lv2_구명보트 {
	static int[] people = {10,20,30,40,50,60,70,80,90,100};
	static int limit = 100;
	public static void main(String[] args) {
		Arrays.sort(people);
		int ans = 0;
		int cnt = 0;
		int start  = 0;
		int end = people.length-1;
		while(cnt!= people.length) {
			if(start == end) {
				ans++;
				break;
			}
			if(people[end] + people[start] > limit) {
				ans++;
				cnt++;
				end--;
			}else {
				ans++;
				cnt+=2;
				end--;
				start++;
			}
		}
		System.out.println(ans);
	}

}

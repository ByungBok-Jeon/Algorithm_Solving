
/* Lv1. 완주하지못한선수
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42576
 * 프로그래머스 문제
 */
import java.util.Arrays;

public class Solution_PR_Lv1_완주하지못한선수 {
//	static String[] p = {"leo", "kiki", "eden"};
//	static String[] c = {"eden", "kiki"};
	
	public static String solution(String[] participant, String[] completion) {
		
        String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		for (int i = 0; i < completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				answer = participant[i];
				break;
			}
		}
		if(answer.equals("")) return participant[participant.length-1];
		else return answer;
    }
//	public static void main(String[] args) {
//		String s = solution(p, c);
//		System.out.println(s);
//	}
}

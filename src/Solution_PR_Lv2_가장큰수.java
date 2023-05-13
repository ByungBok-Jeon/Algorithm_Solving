import java.util.Arrays;

public class Solution_PR_Lv2_가장큰수 {
	public String solution(int[] numbers) {
		String answer = "";

		String[] s = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			s[i] = "" + numbers[i];
		}

		Arrays.sort(s, (s1,s2)->(s2+s1).compareTo(s1+s2));
		for (int i = 0; i < numbers.length; i++) {
			answer+= s[i];
		}
		while(answer.charAt(0)=='0' && answer.length()>1){
			answer = answer.substring(1);
		}
		return answer;
    }

}

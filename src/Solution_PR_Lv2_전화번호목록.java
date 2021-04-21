
/* Lv2. 전화번호목록
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42577
 * 프로그래머스 문제
 * 효율성 3,4 시간초과
 */
import java.util.Arrays;
import java.util.Comparator;

public class Solution_PR_Lv2_전화번호목록 {

	public static void main(String[] args) {
		String[] pb = {"12","123","1235","567","88"};
		boolean v = solution(pb);
		System.out.println(v);
	}
	public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
        	
        });
        for (int i = 0; i < phone_book.length; i++) {
			for (int j = i+1; j < phone_book.length; j++) {
				if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
					return false;
				}
			}
		}
        return true;
    }

}

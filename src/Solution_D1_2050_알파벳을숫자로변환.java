
/* D1.2050. 알파벳을 숫자로 변환
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QLGxKAzQDFAUq&categoryId=AV5QLGxKAzQDFAUq&categoryType=CODE&&&
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D1_2050_알파벳을숫자로변환 {
	static String input;
	static char alphabet;

	public static void main(String[] args) {

//A = 65
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		for (int i = 0; i < input.length(); i++) {
			System.out.printf("%d ", input.charAt(i) - 64);
		}

	}

}

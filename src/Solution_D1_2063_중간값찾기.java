/* D1.2063. 중간값 찾기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QPsXKA2UDFAUq&categoryId=AV5QPsXKA2UDFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D1_2063_중간값찾기 {
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = scan.nextInt();
		}
		Arrays.sort(input);
		System.out.println(input[N/2]);
		
	}

}

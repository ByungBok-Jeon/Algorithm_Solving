import java.util.Scanner;

/* D1.2072.홀수만 더하기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QSEhaA5sDFAUq&categoryId=AV5QSEhaA5sDFAUq&categoryType=CODE&&&
 * SW Expert Acadamy 문제
 */
public class Solution_D1_2072_홀수만더하기 {
	
	public static boolean isEven(int num) {
		boolean isE = false;
		if(num % 2 == 0) {
			isE = true;
		}
		return isE;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[10];
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int sum = 0;
			for (int j = 0; j < nums.length; j++) {
				nums[j] = scan.nextInt();
				if(isEven(nums[j]) == false) {
					sum += nums[j];
				}
				
			}
			System.out.printf("#%d %d\n", (i+1), sum);
		}

	}

}

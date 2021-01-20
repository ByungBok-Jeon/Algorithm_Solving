/* D1.2070.큰 놈, 작은 놈, 같은 놈
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QQ6qqA40DFAUq&categoryId=AV5QQ6qqA40DFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D1_2070_큰놈작은놈같은놈 {
	static int T;
	static int input1, input2;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			String c ="";
			input1=scan.nextInt();
			input2=scan.nextInt();
			if(input1 == input2) {
				c = "=";
			}else if(input1>input2) {
				c= ">";
			}else if(input1<input2) {
				c= "<";
			}
			System.out.println("#"+t+" "+ c);
			
		}

	}

}

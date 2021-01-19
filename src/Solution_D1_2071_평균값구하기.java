import java.util.Scanner;

/* D1.2071.평균값 구하기
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QRnJqA5cDFAUq&categoryId=AV5QRnJqA5cDFAUq&categoryType=CODE&&&
 * SW Expert Acadamy 문제
 */
 public class Solution_D1_2071_평균값구하기 {
	 public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for(int i = 0; i<T ; i++) {
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				sum += scan.nextInt();
				
			}
			System.out.printf("#%d %d\n",(i+1),(sum/10));
		}
	}
	
	
}

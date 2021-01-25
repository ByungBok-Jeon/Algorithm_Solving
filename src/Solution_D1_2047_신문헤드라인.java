/* D1.2047. 신문 헤드라인
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QKsLaAy0DFAUq&categoryId=AV5QKsLaAy0DFAUq&categoryType=CODE
 * SW Expert Acadamy 문제
 */
import java.util.Scanner;

public class Solution_D1_2047_신문헤드라인 {
	static String input,output;
	static char[] arrCh;
	public static void main(String[] args) {
//		//32차이남 97 ~ 122
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		arrCh = input.toCharArray();
		for (int i = 0; i < arrCh.length; i++) {
			if(arrCh[i] >= 97 && arrCh[i] <=122) {
				arrCh[i] -= 32;
			}
		}
		output = String.valueOf(arrCh);
		System.out.println(output);
	
	} 

}

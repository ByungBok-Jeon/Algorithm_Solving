
/* D2.1928. Base 64 Decoder
 * 출처 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PR4DKAG0DFAUq&categoryId=AV5PR4DKAG0DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=30&pageIndex=1
 * SW Expert Acadamy 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Solution_D2_1928_Base64Decoder {
	static int T;
	static String input, output;
	static ArrayList<Character> charArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		charArr = new ArrayList<>();
		for (char i = 'A'; i <= 'Z'; i++) {
			charArr.add(i);
		}
		for (char i = 'a'; i <= 'z'; i++) {
			charArr.add(i);
		}
		for (char i = '0'; i <= '9'; i++) {
			charArr.add(i);
		}
		charArr.add('+');
		charArr.add('/');
		for (int t = 1; t <= T; t++) {
			input=br.readLine();
			output="";
			String tmpS = "";
			int cnt = 0;
			for (int i = 0; i < input.length(); i++) {
				int idx =charArr.indexOf(input.charAt(i));
				
				tmpS+= six(Integer.toBinaryString(idx));
				cnt++;
				if(cnt==4) {
					for (int j = 0; j < 3; j++) {
						String eightS = "";
						for (int k = j*8; k < j*8+8; k++) {
							eightS+=tmpS.charAt(k);
						}
						output+=(char)Integer.parseInt(eightS,2);
					}
					cnt=0;
					tmpS="";
				}
			}
			System.out.println("#"+t+ " " + output);
		}
	}
	static String six(String s) {
		while(s.length()<6) {
			String tmp = "0";
			tmp+=s;
			s= tmp;
		}
		return s;
	}
}
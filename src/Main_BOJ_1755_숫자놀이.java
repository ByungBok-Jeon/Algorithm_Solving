
/* 1755번 숫자놀이
 * 출처 : https://www.acmicpc.net/problem/1755
 * Baekjoon Online Judge  문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1755_숫자놀이 {
	static int M,N;
	static String[] alpha = {"zero","one","two","three","four","five","six","seven","eight","nine"}; //0~9를 string 배열에 저장
	static List<Num> list; // 숫자를 담을 list
	
	static class Num implements Comparable<Num>{ //숫자를 영어로 읽었을때와 숫자 자체를 저장할 Num 클래스
		String s;
		int n;
		public Num(String s, int n) {
			this.s = s;
			this.n = n;
		}
		@Override
		public int compareTo(Num o) { //정렬할때 인덱스 마다 비교하고 인덱스가 같으면 다음 인덱스를 비교하여 반환하는 메소드
			for (int i = 0; i < Math.min(this.s.length(), o.s.length()); i++) {
				if(this.s.charAt(i)==o.s.charAt(i)) continue;
				else return Character.compare(this.s.charAt(i), o.s.charAt(i));
			}
			return 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = M; i <= N; i++) { // M이상 N이하 까지
			String s = Integer.toString(i); //숫자를 string형으로 저장
			String tmp = ""; //영어로 읽은 숫자를 담을 변수
			for (int j = 0; j < s.length(); j++) { //0~9의 숫자를 alpha에 저장된 문자로 변환하기 위해 사용하는 반복문
				for (int k = 0; k <= 9; k++) { // 숫자가 인덱스 번호와 같다면 그 문자를 tmp에 더해줌
					if(s.charAt(j) - '0' == k) {
						tmp+=alpha[k];
						break;
					}
				}
			}
			list.add(new Num(tmp,i)); //list에 숫자들을 담음
		}
		Collections.sort(list); // 숫자를 Num클래스의 string형 s를 비교하여 정렬
		for (int i = 0; i < list.size(); i++) { //출력 반복문
			if(i!=0 &&(i+1)%10==0) System.out.println(list.get(i).n); //10개 출력했으면 다음줄로
			else System.out.print(list.get(i).n+" ");
		}
	}

}

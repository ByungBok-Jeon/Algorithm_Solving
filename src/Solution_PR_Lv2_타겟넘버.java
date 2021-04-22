
/* Lv2. 타겟넘버
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/43165
 * 프로그래머스 문제
 */

public class Solution_PR_Lv2_타겟넘버 {

	
	static int ans;
    static int[] nums;
    static int targ;
    public int solution(int[] numbers, int target) {
        ans = 0;
        nums = numbers;
        targ = target;
        dfs(0,0);
        return ans;
    }
    public void dfs(int cnt, int sum){
        if(cnt==nums.length){
            if(sum==targ) ans++;
            return;
        }
        dfs(cnt+1,sum+nums[cnt]);
        dfs(cnt+1,sum-nums[cnt]);
    }

}

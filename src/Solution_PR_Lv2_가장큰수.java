import java.util.Arrays;
import java.util.Comparator;

public class Solution_PR_Lv2_가장큰수 {
	public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			nums[i] = Integer.toString(numbers[i]);
		}
		Arrays.sort(nums, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return -(o1+o2).compareTo(o2+o1);
			}
		});
        if(nums[0].equals("0")) return "0";
		String ans = "";
		for (int i = 0; i < nums.length; i++) {
			ans += nums[i];
		}
		return ans;
    }

}

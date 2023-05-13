public class Solution_PR_LV2_이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = convert(s, new int[] {0,0});

        return answer;
    }

    public int[] convert(String s, int[] arr){
        if(s.equals("1")) return arr;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                arr[1]++;
            }
        }
        s = s.replace("0","");
        return  convert(Integer.toBinaryString(s.length()), new int[] {arr[0]+1, arr[1]});
    }
}

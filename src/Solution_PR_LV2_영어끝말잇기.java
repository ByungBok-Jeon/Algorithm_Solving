import java.util.HashSet;

public class Solution_PR_LV2_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        // 1. 끝말을 이었는가
        // 2. 중복단어를 말했는가
        int[] answer = {};
        int cnt = 1;
        int idx = 1;
        boolean pass = true;
        char lastSpell = words[0].charAt(words[0].length()-1);
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);

        for(int i=1; i< words.length; i++){
            cnt = (i/n)+1;
            char first = words[i].charAt(0);

            if(set.contains(words[i])){
                pass = false;
                idx = (i % n) + 1;
                break;
            }

            if(lastSpell != first){
                pass = false;
                idx = (i % n) + 1;
                break;
            }

            lastSpell = words[i].charAt(words[i].length()-1);
            set.add(words[i]);

        }

        if(pass) return new int[]{0,0};
        return new int[]{idx, cnt};
    }
}

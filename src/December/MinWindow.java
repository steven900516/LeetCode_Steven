package December;

/**
 * @author Steven0516
 * @create 2021-12-11
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0){
            return "";
        }

        int[] needs = new int[128];
        for(int i = 0;i < t.length();i++){
            needs[t.charAt(i)]++;
        }
        int count = t.length();
        int start = 0;
        int size = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        while(r < s.length()){
            char tmp = s.charAt(r);
            if(needs[tmp] > 0){
                count--;
            }
            needs[tmp]--;
            if(count == 0){
                while(l < r && needs[s.charAt(l)] < 0){
                    needs[s.charAt(l)]++;
                    l++;
                }

                if(r - l + 1 < size){
                    size = r - l + 1;
                    start = l;
                }
                needs[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start,start + size);
    }
}

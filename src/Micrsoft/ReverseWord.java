package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-02-03
 */
public class ReverseWord {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                reverse(chars,start,i - 1);
                start = i + 1;
                continue;
            }
            if(i == chars.length - 1){
                reverse(chars,start, chars.length - 1);
            }
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int i) {
        while(start < i){
            char tmp = chars[start];
            chars[start] = chars[i];
            chars[i] = tmp;
            start++;
            i--;
        }
    }
}

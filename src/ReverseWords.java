/**
 * @author Steven0516
 * @create 2021-09-19
 */

//反转单词顺序
public class ReverseWords {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if(!s1[i].equals("")){
                if(i == 0){
                    stringBuilder.append(s1[i]);
                }else{
                    stringBuilder.append(s1[i]+ " ");
                }

            }
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("  hello world!  ").length());
    }
}

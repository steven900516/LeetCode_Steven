package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-14
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if(s.length == 1) return;
        int head = 0;
        int tail = s.length - 1;
        while(head < s.length / 2){
            swap(s,head,tail);
            head++;
            tail--;
        }
    }

    public void swap(char[] s,int head,int tail){
        char tmp = s[head];
        s[head] = s[tail];
        s[tail] = tmp;
    }
}

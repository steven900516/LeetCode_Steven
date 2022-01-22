package Micrsoft;

/**
 * @author Steven0516
 * @create 2022-01-22
 */
public class MinDistance {
    public int minDistance(String w1, String w2) {
        int m = w1.length();
        int n = w2.length();
        return caculate(w1,w2,m - 1,n - 1);
    }


    public int caculate(String w1, String w2,int m,int n){
        if(m < 0 || n < 0 ){
            return m < 0 ? n + 1 : m + 1;
        }

        if(w1.charAt(m) == w2.charAt(n)){
            return caculate(w1,w2,m - 1,n - 1);
        }else{
            return min(caculate(w1,w2,m,n - 1),
                    caculate(w1,w2,m - 1,n - 1),
                    caculate(w1,w2,m - 1,n)) + 1;
        }

    }


    int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
}

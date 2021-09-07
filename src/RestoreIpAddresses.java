import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-09-07
 */
public class RestoreIpAddresses {
    List<String> ans=new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {

        if(s.length()<3 || s.length()>12)
            return ans;
        findAns(0,s,0,"");

        return ans;
    }

    private void findAns(int num,String s,int p,String res)
    {
        if(num>3) return;
        if(num==3 && p==s.length())
        {
            ans.add(res);
            return;
        }
        int sum=0;
        for(int i=p;i<s.length();i++)
        {
            sum=sum*10+(s.charAt(i)-48);

            if(sum>255) return;

            if(p>0)
                findAns(num+1,s,i+1,res+"."+s.substring(p, i+1));
            else
                findAns(num,s,i+1,res+s.substring(p, i+1));

            if(sum==0) break;
        }
    }



    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("25525511135"));

    }

}

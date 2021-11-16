package company;

import java.util.LinkedList;

/**
 * @author Steven0516
 * @create 2021-11-16
 */
public class SumNumbers {
    LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int answer = 0;
        LinkedList<Integer> path = new LinkedList<>();
        recur(root,path);
        for(int i = 0;i < res.size();i++){
            int n = res.get(i).size();
            LinkedList tmp = res.get(i);
            int sum = 0;
            for(int j = 0;j < n;j++){
                int p = pow2(n - j - 1);
                sum += p * res.get(i).get(j);
            }
            System.out.println(sum);
            answer += sum;
        }
        return answer;
    }

    public void recur(TreeNode root,LinkedList path){
        if(root == null){
            return;
        }

        path.add(root.val);

        if(root.left == null && root.right == null){
            System.out.println(path);
            res.add(new LinkedList<>(path));
        }


        recur(root.left,path);
        recur(root.right,path);
        path.removeLast();
    }


    public int pow2(int pow){
        int ans = 1;
        for(int i = 0;i < pow;i ++){
            ans = ans  * 10;
        }
        return ans;
    }

}

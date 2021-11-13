package company;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-11-13
 */
public class Permute {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 1){
            LinkedList<Integer> path = new LinkedList<>();
            path.add(nums[0]);
            res.add(path);
            return  res;
        }
        LinkedList<Integer> path = new LinkedList<>();

        back(path,nums);

        return res;
    }
    void back(LinkedList<Integer> path, int[] nums){

        if(path.size() ==  nums.length){
            res.add(new LinkedList<>(path));
            System.out.println("path添加至path中：" + path + "即将retrun----------------");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])){
                System.out.println(nums[i] + "已经有了哦~即将continue");
                continue;
            }
            path.add(nums[i]);
            System.out.println("添加完一个元素，此时path:" + path);
            back(path,nums);
            path.removeLast();
            System.out.println("移除完一个元素，此时path:" + path);
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }

}

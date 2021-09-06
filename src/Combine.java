import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Steven0516
 * @create 2021-09-05
 */

//回溯算法（77）
public class Combine {
    List<List<Integer>> tot = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  i + 1;
        }
        backTrack(arr,k,temp,0);
        return tot;
    }


    private void backTrack(int[] arr,int k,ArrayList<Integer> temp,int index){
        if(temp.size() == k){
            tot.add(new ArrayList<>(temp));  //注意new 一个新的List
            return;
        }
        for(int i = index;i < arr.length;i++){
            temp.add(arr[i]);
            backTrack(arr,k,temp,i + 1);
            temp.remove(temp.size() - 1);
        }
    }




    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }
}

/**
 * @author Steven0516
 * @create 2021-10-06
 */
public class ReversePair {
    int res=0;
    public int reversePairs(int[] nums)
    {
        int[] temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);
        return res;
    }
    public void mergeSort(int[] a,int left,int right,int[] temp)
    {
        if(left<right)
        {
            int mid=left+(right-left)/2;
            mergeSort(a,left,mid,temp);
            mergeSort(a,mid+1,right,temp);
            merge(a,left,mid,right,temp);
        }
    }
    public void merge(int[] a, int left, int mid, int right, int[] temp)
    {
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=right)
        {
            if(a[i]<=a[j])
            {
                temp[k++]=a[i++];
            }
            else
            {
                temp[k++]=a[j++];
                res+=mid-i+1;//仅仅比归并排序多这一行代码
            }
        }
        while(i<=mid)
        {
            temp[k++]=a[i++];
        }
        while(j<=right)
        {
            temp[k++]=a[j++];
        }
        k=0;
        while(left<=right)
        {
            a[left++]=temp[k++];
        }
    }
}

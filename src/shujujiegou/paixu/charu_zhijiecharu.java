package shujujiegou.paixu;

import java.util.Arrays;

public class charu_zhijiecharu {
    public static void main(String[] args){
        int[] arr=new int[]{5,3,4,7,1,2,8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                int temp=arr[i];
                int j;
                for(j=i-1;j>=0&&arr[j]>temp;j--){
                    arr[j+1]=arr[j];
                }
                arr[j+1]=temp;
            }
        }
    }
}

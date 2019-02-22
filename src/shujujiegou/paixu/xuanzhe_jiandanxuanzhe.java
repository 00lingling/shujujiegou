package shujujiegou.paixu;

import java.util.Arrays;

public class xuanzhe_jiandanxuanzhe {
    public static void main(String[] args){
      int[] arr=new int[]{3,4,5,7,1,2,0,3,6,8};
      selectSort(arr);
      System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            if (i!=min){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
    }
}

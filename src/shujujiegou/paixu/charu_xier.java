package shujujiegou.paixu;

import java.util.Arrays;

public class charu_xier {
    public static void main(String[] args){
        int[] arr=new int[]{5,7,2,3,1,8,9,0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr){
        for(int d=arr.length/2;d>0;d/=2){
           for(int i=d;i<arr.length;i++){
                for(int j=i-d;j>=0;j-=d){
                    if(arr[j]>arr[j+d]){
                        int temp=arr[j];
                        arr[j]=arr[j+d];
                        arr[j+d]=temp;
                    }
                }
           }
            System.out.println(Arrays.toString(arr));
        }
    }
}

package shujujiegou.paixu;

import java.util.Arrays;

public class jiaohuan_maopao {
    public static void main(String[] args){
        int[] arr=new int[] {5,7,2,9,4,1,0,5,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        }
    //冒泡排序,从小到大
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i <arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}


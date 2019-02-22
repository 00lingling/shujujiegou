package shujujiegou.paixu;

import java.util.Arrays;

public class guibing {
    public static void main(String[] args){
        int[] arr=new int[]{2,3,5,2,1,0,8,4,3,1};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void mergeSort(int[] arr,int low,int higt) {
        int middle = (higt + low) / 2;
        if (low < higt) {
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, higt);
            merge(arr, low, middle, higt);
        }
    }
    public static void merge(int[] arr,int low,int middle,int high){
        int[] temp=new int[high-low+1];
        int i=low;
        int j=middle+1;
        int index=0;
        while(i<=middle&&j<=high){
            if(arr[i]<=arr[j]){
                temp[index]=arr[i];
                i++;
            }else{
                temp[index]=arr[j];
                j++;
            }
            index++;
        }
        while (j<=high){
            temp[index]=arr[j];
            j++;
            index++;
        }
        while (i<=middle){
            temp[index]=arr[i];
            i++;
            index++;
        }
        for(int k=0;k<temp.length;k++){
            arr[k+low]=temp[k];
        }
    }
}

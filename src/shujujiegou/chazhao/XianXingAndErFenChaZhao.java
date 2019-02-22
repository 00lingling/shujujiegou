package shujujiegou.chazhao;

import java.util.Arrays;

public class XianXingAndErFenChaZhao {
    public static void main(String[] args){
        int[] arr=new int[] {2,3,4,5,6,7,8};
        double target=2.5;
        int index1=-1;
        //线性查找
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                index1=i;
                break;}
        }
        System.out.println(index1);

        //二分法查找(针对有序数组)
                int start=0;
        int end=arr.length-1;
        int mid;
        while(start<=end){
            mid=(start+end)/2;
            if(target<arr[mid])
                end=mid-1;
            else if(target>arr[mid])
                start=mid+1;
            else {
                index1=mid;
                break;}
        }
        System.out.println(index1);
        //栈和队列，都是通过数组存储，区别在于栈是先进后出，队列是先进先出。
    }
}

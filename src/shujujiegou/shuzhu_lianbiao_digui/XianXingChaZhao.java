package shujujiegou.shuzhu_lianbiao_digui;

import java.util.Arrays;

public class XianXingChaZhao {
    public static void main(String[] args){
        //新建数组并赋值
        int []arr1=new int[3];
        int length1=arr1.length;
        System.out.println("arr1's length is "+length1);
        for(int i=0;i<length1;i++){
            arr1[i]=i;
        }
        System.out.println(Arrays.toString(arr1));
        //在数组的末尾插入一个元素
        int dat=6;
        int[] newarr1=new int[arr1.length+1];
        for(int i=0;i<arr1.length;i++){
            newarr1[i]=arr1[i];
        }
        newarr1[arr1.length]=dat;
        arr1=newarr1;
        System.out.println(Arrays.toString(arr1));
        //插入一个元素到数组的指定位置（首先应该判断指定位置是否合法）
        int index=2;
        int element=11;
        int[] newarr2=new int[arr1.length+1];
        for(int i=0;i<arr1.length;i++){
            if(i<index){
                newarr2[i]=arr1[i];
            }else{
                newarr2[i+1]=arr1[i];
            }
        }
        newarr2[index]=element;
        arr1=newarr2;
        System.out.println(Arrays.toString(arr1));
        //在数组中删除一个元素（首先应该判断指定位置是否合法）
        int dst=2;
        int[] newarr3=new int[newarr1.length-1];
        for(int i=0;i<newarr3.length;i++){
            if(i<dst)
                newarr3[i]=newarr1[i];
            else
                newarr3[i]=newarr1[i+1];
        }
        newarr1=newarr3;
        System.out.println(Arrays.toString(newarr1));
        //线性查找
        int[] arr=new int[] {2,3,4,5,6,7,8};
        double target=2.5;
        int index1=-1;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]==target){
//                index1=i;
//                break;}
//        }
//        System.out.println(index1);
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

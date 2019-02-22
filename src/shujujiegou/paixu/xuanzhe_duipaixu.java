package shujujiegou.paixu;

import java.util.Arrays;

//升序排列使用大顶堆（父节点永远大于子节点）
//降序排列使用小顶堆（父节点永远小于子节点）
public class xuanzhe_duipaixu {
    public static void main(String[] args){
        int[] data=new int[]{9,6,8,7,0,1,10,4,2};
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }
    //把一颗子树转成大顶堆,从最后一个非叶子节点开始
    public static void maxHeap(int[] arr,int size,int index){
        int lNode=2*index+1;
        int rNode=2*index+2;
        int max=index;
        if(lNode<size&&arr[lNode]>arr[max]){
            max=lNode;
        }
        if(rNode<size&&arr[rNode]>arr[max]){
            max=rNode;
        }
        if(max!=index){
            int temp=arr[index];
            arr[index]=arr[max];
            arr[max]=temp;
            maxHeap(arr,size,max);
        }
    }
    public static void heapSort(int[] arr){
        //将整颗树调整为大顶堆
        int start=(arr.length-1)/2;
        for(int i=start;i>=0;i--){
            maxHeap(arr,arr.length,i);
        }
        //先把数组中的第0个和最后一个交换位置，再把前面的处理为大顶堆（从根节点开始）
        for(int i=arr.length-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            maxHeap(arr,i,0);
        }
    }
}

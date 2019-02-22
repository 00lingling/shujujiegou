package shujujiegou.shu;
//顺序存储的二叉树通常情况下只考虑完全二叉树
//数组（根节点是第0个元素）中第n个元素的左子节点是：2*n+1
//数组（根节点是第0个元素）中第n个元素的右子节点是：2*n+2
//数组（根节点是第0个元素）中第n个元素的父节点是：（n-1)*2
public class ArrayBinaryTree {
    int [] data;
    public ArrayBinaryTree(int[] data){
        this.data=data;
    }
    //前序遍历
    public void frontShow(int index){
        if(data==null||data.length==0)
            return;
        System.out.println(data[index]);
        if(2*index+1<data.length){
            frontShow(2*index+1);
        }
        if(2*index+2<data.length){
            frontShow(2*index+2);
        }
    }


}

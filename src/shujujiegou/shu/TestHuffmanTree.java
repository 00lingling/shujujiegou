package shujujiegou.shu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//创建赫夫曼树
//循环（排序；然后取出来权值最小的两个二叉树，创建一颗新的二叉树；）
public class TestHuffmanTree {
    public static void main(String[] args){
        int[] arr={3,7,8,29,5,11,23,14};
        TreeNode node=createHuffmanTree(arr);
        System.out.println(node);
    }
    public static TreeNode createHuffmanTree(int[] arr){
        List<TreeNode> nodes=new ArrayList<>();
        for(int value:arr){
            nodes.add(new TreeNode(value));
        }
        while (nodes.size()>1){
            Collections.sort(nodes);
            TreeNode left=nodes.get(nodes.size()-1);
            TreeNode right=nodes.get(nodes.size()-2);
             TreeNode parent=new TreeNode(left.value+right.value);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

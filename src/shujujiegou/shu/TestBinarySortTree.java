package shujujiegou.shu;

public class TestBinarySortTree {
    public static void main(String[] args){
        int[] arr=new int[]{7,3,10,12,5,1,9};
        int[] arr1=new int[]{3,2,1,4,5,6,7,10,9,8};
        BinarySortTree bst=new BinarySortTree();
        BinarySortTree bst1=new BinarySortTree();
        //添加节点
        for(int i:arr){
            bst.add(new Node(i));
        }
        for(int i:arr1){
            bst1.add(new Node(i));
        }
        //中序遍历
        bst.midShow();
        System.out.println("_________________________");
        //查找
        Node node=bst.search(10);
        System.out.println(node.value);
        System.out.println("_________________________");
        //删除叶子节点
        bst.delete(12);
        bst.midShow();
        System.out.println("_________________________");
        //删除只有一个子节点的节点
        bst.delete(10);
        bst.midShow();
        System.out.println("_________________________");
        //删除有两个子节点的节点
        bst.delete(3);
        bst.midShow();
        System.out.println("_________________________");
        //创建平衡二叉树
        System.out.println(bst1.root.height());
        System.out.println(bst1.root.value);
    }
}

package shujujiegou.shu;

public class TestBinaryTree {
    public static void main(String[] args){
        BinaryTree tree=new BinaryTree();
        TreeNode root=new TreeNode(1);
        tree.setRoot(root);
        TreeNode lroot=new TreeNode(2);
        root.setlNode(lroot);
        TreeNode rroot=new TreeNode(3);
        root.setrNode(rroot);
        lroot.setlNode(new TreeNode(4));
        lroot.setrNode(new TreeNode(5));
        rroot.setlNode(new TreeNode(6));
        rroot.setrNode(new TreeNode(7));
        //前序遍历
        tree.frontShow();
        System.out.println("=================================");
        //中序遍历
        tree.midShow();
        System.out.println("=================================");
        //后序遍历
        tree.afterShow();
        System.out.println("+++++++++++++++++++++++++++++++++");
        //前序查找
        TreeNode result=tree.frontSearch(5);
        System.out.println(result);
        System.out.println("+++++++++++++++++++++++++++++++++");
        //删除一个子树
        tree.delete(7);
        tree.frontShow();
        System.out.println("+++++++++++++++++++++++++++++++++");
        //中序线索化二叉树
        tree.treeNodes();
        //遍历线索化二叉树
        tree.treeIterate();

    }
}

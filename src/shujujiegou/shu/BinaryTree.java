package shujujiegou.shu;

public class BinaryTree {
    TreeNode root;
    public void setRoot(TreeNode root){
        this.root=root;
    }
    public TreeNode getRoot(){
        return this.root;
    }

    //中序线索化二叉树
    TreeNode pre=null;          //临时存储前驱节点
    public void treeNodes(){
        treeNodes(root);
    }
    public void treeNodes(TreeNode node){
        if (node==null)
            return;
        treeNodes(node.lNode);
        if(node.lNode==null){
            node.leftType=1;
            node.lNode=pre;
        }
        if(pre!=null&&pre.rNode==null){
            pre.rightType=1;
            pre.rNode=node;
        }
        pre=node;
        treeNodes(node.rNode);
    }
    //线索二叉树的遍历
    public void treeIterate(){
        TreeNode node=root;
        while (node!=null){
            while (node.leftType==0){
                node=node.lNode;
            }
            System.out.println(node.value);
            while (node.rightType==1){
                node=node.rNode;
                System.out.println(node.value);
            }
           node=node.rNode;
        }
    }


    public void frontShow() {
        if (root != null) {
            root.frontShow();
        }
    }
    public void midShow() {
        if (root != null) {
            root.midShow();
        }
    }
    public void afterShow() {
        if (root != null) {
            root.afterShow();
        }
    }
    public TreeNode frontSearch(int i){
       return root.frontSearch(i);
    }

    public void delete(int i) {
        if(root.value==i)
            root=null;
        else{
            root.delete(i);
        }
    }

}

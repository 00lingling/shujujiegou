package shujujiegou.shu;

public class TreeNode implements Comparable<TreeNode>{
    int value;
    TreeNode lNode;
    TreeNode rNode;
    int leftType;
    int rightType;
    public TreeNode(int value){
        this.value=value;
    }
    @Override
    public int compareTo(TreeNode o){
        return -(this.value-o.value);
    }
    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }


    public void setlNode(TreeNode lNode){
        this.lNode=lNode;
    }
    public void setrNode(TreeNode rNode){
        this.rNode=rNode;
    }
    public void frontShow(){
        System.out.println(value);
        if(lNode!=null)
            lNode.frontShow();
        if (rNode!=null)
            rNode.frontShow();
    }
    public void midShow(){
        if(lNode!=null)
            lNode.midShow();
        System.out.println(value);
        if (rNode!=null)
            rNode.midShow();
    }
    public void afterShow(){
        if(lNode!=null)
            lNode.afterShow();
        if (rNode!=null)
            rNode.afterShow();
        System.out.println(value);

    }
    public TreeNode frontSearch(int i){
        TreeNode result=null;
        if(this.value==i)
            return this;
        else {
            if(lNode!=null)
                result = lNode.frontSearch(i);
            if(result!=null)
                return result;
            if(rNode!=null)
                result=rNode.frontSearch(i);
            return result;
        }
    }

    public void delete(int i) {
        TreeNode parent =this;
        if(parent.lNode!=null&&parent.lNode.value==i){
            parent.lNode=null;
            return;
        }
        if(parent.rNode!=null&&parent.rNode.value==i){
            parent.rNode=null;
            return;
        }
        parent=lNode;
        if(parent!=null)
            parent.delete(i);
        parent=rNode;
        if(parent!=null)
            parent.delete(i);
    }
}

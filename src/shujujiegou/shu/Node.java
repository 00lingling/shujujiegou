package shujujiegou.shu;

public class Node {
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value=value;
    }

    //返回当前节点的高度
    public  int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }
    public int leftHeight(){
        if(left==null)
            return 0;
        return left.height();
}
    public int rightHeight(){
        if(right==null)
            return 0;
        return right.height();
    }

    public void add(Node node) {
        if(node==null)
            return;
        if(this.value>node.value) {
            if (this.left == null)
                this.left = node;
            else
                this.left.add(node);
        }
        else {
            if(this.right==null)
                this.right=node;
            else
                this.right.add(node);
        }
        //查询是否平衡（AVL）
        //右旋转
        if(leftHeight()-rightHeight()>=2){
           if(left!=null&&left.leftHeight()<left.rightHeight())
               left.leftRotate();
            rightRotate();
       //左旋转
        }
        if(rightHeight()-leftHeight()>=2){
            if(right!=null&&right.leftHeight()>right.rightHeight())
                right.rightRotate();
            leftRotate();
        }
    }

    private void leftRotate() {
        Node node=new Node(value);
        node.left=left;
        node.right=right.left;
        value=right.value;
        right=right.right;
        left=node;
    }

    private void rightRotate() {
        Node node=new Node(value);
        node.right=right;
        node.left=left.right;
        value=left.value;
        left=left.left;
        right=node;
    }


    public void midShow() {
         if(left!=null)
            left.midShow();
        System.out.println(this.value);
        if(right!=null)
             right.midShow();
    }

    public Node search(int value) {
        if(this.value==value)
            return this;
        else
            if(value<this.value) {
                if (left == null)
                    return null;
                return left.search(value);
            }else
                {
                if (right == null)
                    return null;
                return right.search(value);
            }
    }

    public Node searchParent(int value) {
        if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value))
            return this;
        else{
            if(this.value>value&&this.left!=null)
                return this.left.searchParent(value);
            else{
                if(this.value<value&&this.right!=null)
                    return this.right.searchParent(value);
                return null;
            }
        }
    }
}

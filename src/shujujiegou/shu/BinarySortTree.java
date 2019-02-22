package shujujiegou.shu;

public class BinarySortTree {
    Node root;
    //向二叉树中添加节点
    public void add(Node node){
        if(root==null)
            root=node;
        else
            root.add(node);
    }
    //中序遍历二叉排序树，结果会从小到大的顺序
    public void midShow(){
        if(root!=null)
            root.midShow();
    }
    //查找二叉排序树
    public Node search(int value){
        if(root==null)
            return null;
        else
           return root.search(value);
    }
    //删除子节点
    public void delete(int value){
        if(root==null)
            return;
        else {
            Node target=search(value);
            if(target==null)
                return;
            //寻找要删除节点的父节点
            Node parent=searchParent(value);
            //要删除的节点是叶子节点
            if(target.left==null&&target.right==null){
                if(parent.left.value==value)
                    parent.left=null;
                else
                    parent.right=null;
            //要删除的节点有两个子节点
            } else if(target.left!=null&&target.right!=null){
                //删除右子树中值最小的节点，并获取到该节点的值
                int min=deleteMin(target.right);
                //替换目标节点中的值
                target.value=min;
            //要删除的节点有一个子节点
            }else{
               if(target.left!=null){
                   if(parent.left.value==value)
                       parent.left=target.left;
                   else
                       parent.right=target.left;
               } else{
                   if(parent.left.value==value)
                       parent.left=target.right;
                   else
                       parent.right=target.right;
               }
            }
        }
    }
    //删除一棵树中值最小的节点
    private int deleteMin(Node node) {
        Node target=node;
        //循环找到值最小的节点
        while (target.left!=null){
            target=target.left;
        }
        //删除这个节点
        delete(target.value);
        return target.value;

    }

    public Node searchParent(int value){
        if(root==null)
            return null;
        else
            return root.searchParent(value);
    }
}

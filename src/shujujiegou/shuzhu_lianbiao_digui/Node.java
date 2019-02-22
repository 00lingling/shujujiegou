package shujujiegou.shuzhu_lianbiao_digui;

public class Node {
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
    public Node append(Node node){
        Node currentNode=this;
        while (true){
            Node nextNode=currentNode.next;
            if(nextNode==null){
                break;
            }
            currentNode=nextNode;
        }
        currentNode.next=node;
        return this;
    }
    public Node next(){
        return this.next;
    }
    public int getData(){
        return this.data;
    }
    public boolean isLast(){
        return next==null;
    }
    public void show(){
        Node cureentNode=this;
        while (true){
            System.out.print(cureentNode.data+" ");
            cureentNode=cureentNode.next;
            if(cureentNode==null){
                System.out.println();
                break;
            }
        }
    }
     //删除下一个节点
    public void removeNext(){
        Node newNext=this.next.next;
        this.next=newNext;
    }
    //插入一个节点
    public void after(Node node){
        Node next=this.next;
        this.next=node;
        node.next=next;
    }
}

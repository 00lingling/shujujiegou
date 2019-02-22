package shujujiegou.shuzhu_lianbiao_digui;

public class LoopNode {
    int data;
    LoopNode next=this;
    public LoopNode(int data){
        this.data=data;
    }
    public LoopNode next(){
        return this.next;
    }
    public int getData(){
        return this.data;
    }
      //删除下一个节点
    public void removeNext(){
        LoopNode newNext=this.next.next;
        this.next=newNext;
    }
    //插入一个节点
    public void after(LoopNode node){
        LoopNode next=this.next;
        this.next=node;
        node.next=next;
    }
}

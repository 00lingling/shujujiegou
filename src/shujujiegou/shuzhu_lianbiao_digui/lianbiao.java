package shujujiegou.shuzhu_lianbiao_digui;

public class lianbiao {
    public static void main(String[] args){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        n1.append(n2).append(n3);
        System.out.println(n1.next().next().getData());
        System.out.println(n1.next().isLast());
        n1.show();
        n1.removeNext();
        n1.show();
        Node node =new Node(5);
        n1.after(node);
        n1.show();
        LoopNode m1=new LoopNode(1);
        LoopNode m2=new LoopNode(2);
        LoopNode m3=new LoopNode(3);
        m1.after(m2);
        m2.after(m3);
        System.out.println(m1.next.getData());
        System.out.println(m2.next.getData());
        System.out.println(m3.next.getData());
        DoubleNode p1=new DoubleNode(1);
        DoubleNode p2=new DoubleNode(2);
        DoubleNode p3=new DoubleNode(3);
        p1.after(p2);
        p2.after(p3);
        System.out.println(p1.next.getData());
        System.out.println(p1.getData());
        System.out.println(p1.pre.getData());
        System.out.println(p3.next.getData());
    }
}

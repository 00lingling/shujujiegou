package shujujiegou.tu;

import shujujiegou.shuzhu_lianbiao_digui.MyStack;

//无向图
public class Graph {
    private Vertex[] vertex;
    private int currentSize;
    public int[][] adjMat;
    //遍历时候的栈
    private MyStack stack=new MyStack();
    //当前遍历的下标
    private int currentIndex;


    public Graph(int size){
        vertex=new Vertex[size];
        adjMat=new int[size][size];
    }

    public void addVertex(Vertex v){
        vertex[currentSize++]=v;
    }
    public void addEdge(String v1,String v2){
        //找出两个顶点的下标
        int index1=0;
        for(int i=0;i<vertex.length;i++){
            if(vertex[i].getValue()==v1) {
                index1 = i;
                break;
            }
        }
        int index2=0;
        for(int i=0;i<vertex.length;i++){
            if(vertex[i].getValue()==v2) {
                index2 = i;
                break;
            }
        }
        //修改在邻接矩阵中的值
        adjMat[index1][index2]=1;
        adjMat[index2][index1]=1;
    }
    //深度优先搜索遍历图
    public void dfs(){
        vertex[0].visited=true;
        stack.push(0);
        System.out.println(vertex[0].getValue());
       out: while (!stack.isEmpty()){
            for(int i=0;i<vertex.length;i++){
                if(adjMat[currentIndex][i]==1&&vertex[i].visited==false){
                    stack.push(i);
                    vertex[i].visited=true;
                    System.out.println(vertex[i].getValue());
                    currentIndex=stack.peek();
                    continue out;
                }
            }
            stack.pop();
            if(!stack.isEmpty())
                currentIndex=stack.peek();
        }
    }
}

package shujujiegou.shuzhu_lianbiao_digui;

public class Hanoi {
    public static void main(String[] args){
        hanoi(6,'A','B','C');
    }
    //汉诺塔问题，将n个盘子从from这个柱子挪到to这个柱子，中间的柱子是in
    //注意：无论有多少盘子，都认为只有两个盘子，上面所有盘子和最下面那个盘子。
    public static void hanoi(int n,char from,char in,char to){
        if(n==1){
            System.out.println("第1个盘子从" +from+"移到"+to);
        }else{
            hanoi(n-1,from,to,in);
            System.out.println("第"+n+"个盘子从" +from+"移到"+to);
            hanoi(n-1,in,from,to);
        }

    }
}

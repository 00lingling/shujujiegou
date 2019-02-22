package shujujiegou.Huffman;

import com.sun.beans.editors.ByteEditor;

import java.io.*;
import java.util.*;

public class TestHuffmanCode {
    public static void main(String[] args){
        String msg="can you can a can as a can canner can a can.";
        byte[] bytes=msg.getBytes();
        //进行赫夫曼编码
        byte[] b=huffmanZip(bytes);
        System.out.println(bytes.length);
        System.out.println(b.length);
        //使用赫夫曼编码进行解码
        byte[] newBytes=decode(huffCodes,b);
        System.out.println(new String(newBytes));

        String src="1.bmp";
        String dst="2.zip";
        //使用赫夫曼编码压缩文件
        try {
            zipFile(src,dst);
        }catch (IOException e){
            e.printStackTrace();
        }
        //解码文件
        try {
            unZip("2.zip","3.bmp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //使用赫夫曼编码压缩文件
    public static  void zipFile(String src,String dst) throws IOException{
        FileInputStream is=new FileInputStream(src);
        byte[] b=new byte[is.available()];
        is.read(b);
        is.close();
        byte[] byteZip=huffmanZip(b);
        FileOutputStream os=new FileOutputStream(dst);
        ObjectOutputStream oos=new ObjectOutputStream(os);
        oos.writeObject(byteZip);
        oos.writeObject(huffCodes);
        oos.close();
        os.close();
    }
    //解码
    public  static void unZip(String src,String dst) throws Exception {
        FileInputStream is =new FileInputStream(src);
        ObjectInputStream ois=new ObjectInputStream(is);
        byte[] b=(byte[])ois.readObject();
        Map<Byte,String>codes=(Map<Byte,String>)ois.readObject();
        ois.close();
        is.close();
        byte[] bytes=decode(codes,b);
        FileOutputStream os=new FileOutputStream(dst);
        os.write(bytes);
        os.close();
    }

    private static byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
        //把bytes数组转成二进制的字符串
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<bytes.length;i++){
            byte b=bytes[i];
            boolean flag=!(i==bytes.length-1);
            sb.append(byteToBitStr(flag,b));
        }
        System.out.println(sb.toString());
        //把字符串按照指定的赫夫曼编码进行解码(1，把赫夫曼编码的键值对进行调换2，处理字符串)
        Map<String,Byte>map=new HashMap<>();
        for(Map.Entry<Byte,String>entry:huffCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        List<Byte>list=new ArrayList<>();
        for(int i=0;i<sb.length();){
            int count=1;
            boolean flag=true;
            Byte b=null;
            while (flag){
                String key=sb.substring(i,i+count);
                b=map.get(key);
                if(b==null)
                    count++;
                else
                    flag=false;
            }
            list.add(b);
            i+=count;
        }
        byte[] b=new byte[list.size()];
        for(int i=0;i<b.length;i++){
            b[i]=list.get(i);
        }
        return b;
    }

    private static String byteToBitStr(boolean flag,byte b) {
        int temp=b;
        if(flag)
            temp|=256;
        String str=Integer.toBinaryString(temp);
        if(flag)
            return  str.substring(str.length()-8);
        else
            return str;
    }


    public static byte[] huffmanZip(byte[] bytes){
        //先统计每一个byte出现的次数，并放入一个集合中
        List<Node> nodes=getNodes(bytes);
        //创建一颗赫夫曼树
        Node tree=createHuffmanTree(nodes);
        System.out.println(tree);
        //创建一个赫夫曼编码表
        Map<Byte,String> huffCodes=getCodes(tree);
        System.out.println(huffCodes);
        //编码
        byte[] b=zip(bytes,huffCodes);
        return b;

    }
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb=new StringBuilder();
        for(byte b:bytes){
            sb.append(huffCodes.get(b));
        }
        System.out.println(sb.toString());
        int len;
        if(sb.length()%8==0)
            len=sb.length()/8;
        else
            len=sb.length()/8+1;
        byte[] by=new byte[len];
        int index=0;
        for(int i=0;i<sb.length();i+=8){
            String strByte;
            if(i+8>sb.length())
                strByte=sb.substring(i);
            else
                strByte=sb.substring(i,i+8);
            byte byt=(byte)Integer.parseInt(strByte,2);
            System.out.println(strByte+":"+byt);
            by[index]=byt;
            index++;
        }
        return by;
    }
    static StringBuilder sb=new StringBuilder();
    static Map<Byte,String> huffCodes=new HashMap<>();
    private static Map<Byte, String> getCodes(Node tree) {
        if(tree==null)
            return null;
        getCodes(tree.left,"0",sb);
        getCodes(tree.right,"1",sb);
        return huffCodes;
    }
    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2=new StringBuilder(sb);
        sb2.append(code);
        if(node.data==null){
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb2);
        }else
            huffCodes.put(node.data,sb2.toString());
    }

    public static List<Node> getNodes(byte[] bytes){
        List<Node> nodes=new ArrayList<>();
        Map<Byte,Integer> counts=new HashMap<>();
        for(byte b:bytes){
            Integer count=counts.get(b);
            if(count==null)
                counts.put(b,1);
            else
                counts.put(b,count+1);
        }
          for(Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
    public static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node left=nodes.get(nodes.size()-1);
            Node right=nodes.get(nodes.size()-2);
            Node parent=new Node(null,left.weight+right.weight);
            parent.left=left;
            parent.right=right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

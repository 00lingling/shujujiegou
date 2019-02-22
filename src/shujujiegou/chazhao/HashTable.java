package shujujiegou.chazhao;

public class HashTable {
    private StuInfo[] data=new StuInfo[100];
    //向散列表中添加元素
    public void put(StuInfo stuInfo){
        //获取存取位置
        int index=stuInfo.hashCode();
        data[index]=stuInfo;
    }
    //从散列表中取出元素
    public StuInfo get(StuInfo stuInfo){
        //获取存取位置
        int index=stuInfo.hashCode();
        return data[index];
    }
}

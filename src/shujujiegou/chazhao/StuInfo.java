package shujujiegou.chazhao;

public class StuInfo {
    private int age;
    private int number;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public StuInfo(int age, int number) {
        this.age = age;
        this.number = number;
    }

    public StuInfo(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "age=" + age +
                ", number=" + number +
                '}';
    }

    //散列函数(取余法)
    public int hashCode(){
        return age%10;
    }
}

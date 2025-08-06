package lesson_1_5_staticandmemory.statictest;

public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3("A");
        System.out.println("A count=" + data1.count);
        Data3 data2 = new Data3("B");
        System.out.println("B count=" + data2.count);
        Data3 data3 = new Data3("C");
        System.out.println("C count=" + data3.count);
        Data3 data4 = new Data3("D");
        System.out.println(data4.count);
        System.out.println(Data3.count);
    }
}

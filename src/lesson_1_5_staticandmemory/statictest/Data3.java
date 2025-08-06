package lesson_1_5_staticandmemory.statictest;

public class Data3 {
    public String name;
    public static int count;

    public Data3(String name) {
        this.name = name;
        count++;
    }
}

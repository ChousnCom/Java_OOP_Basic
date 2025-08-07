package lesson_1_6_final.Final;

public class FinalRefMain {
    public static void main(String[] args) {
        final Data data = new Data(); // data 는 참조값을 변경할 수 없다는 의미.
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);
    }
}

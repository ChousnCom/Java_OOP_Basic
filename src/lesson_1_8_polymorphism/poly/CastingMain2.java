package lesson_1_8_polymorphism.poly;

public class CastingMain2 {
    public static void main(String[] args) {

        Parent poly = new Child();

        //일시적 다운 캐스팅
        ((Child)poly).childMethod();
    }
}

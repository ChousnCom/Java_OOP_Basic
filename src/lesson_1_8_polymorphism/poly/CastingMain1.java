package lesson_1_8_polymorphism.poly;

public class CastingMain1 {
    public static void main(String[] args) {
        //부모 타입은 자식 인스턴스 참조 가능(다형적 참조)
        Parent poly = new Child();

        //다운 캐스팅 시작. 부모 타입을 -> 하위 자식 타입으로
        Child child = (Child) poly;
        child.childMethod();
    }
}

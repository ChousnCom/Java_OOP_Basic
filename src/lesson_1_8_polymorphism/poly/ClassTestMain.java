package lesson_1_8_polymorphism.poly;

public class ClassTestMain {
    public static void main(String[] args) {
        ClassA A = new ClassC(); // 클래스 A 클래스 C로 업캐스팅
        ClassB B = new ClassC(); // 클래스 B 클래스 C로 업캐스팅
        ClassC C = new ClassC(); // 자기 자신과 같은 타입.

        //Method A호출.
        A.methodA(); //A.MethodA는 호출 가능 그러나, 하위 자식 타입의 메서드는 호출 불가.
        B.methodA(); //B 도 부모의 메서드인 A에 접근 가능 상속관걔.
        C.methodA(); //C 또한 메서드 A에 접근 가능.

        System.out.println();

        System.out.println("메서드 B 출력");
        //A.methodB(); -> 접근 불가 접근하려면 다운캐스팅 필요.
        ((ClassB)A).methodB(); //일시적 다운캐스팅을 통한 메서드 B 접근
        C.methodB(); // C는 B의 상속을 받고 있음 -> 부모 클래스의 메서드에 접근 가능.

        System.out.println();

        System.out.println("메서드 C 출력");
        ((ClassC)A).methodC();
        ((ClassC)B).methodC();
        C.methodC();
    }
}

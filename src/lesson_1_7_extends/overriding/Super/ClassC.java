package lesson_1_7_extends.overriding.Super;

public class ClassC extends ClassB {
    public ClassC(){
        super(10,20); //B의 생성자 호출 및 매개변수 값 할당
        System.out.println("Class C 생성자");
    }
}

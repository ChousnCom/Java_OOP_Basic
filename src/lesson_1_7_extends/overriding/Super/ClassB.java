package lesson_1_7_extends.overriding.Super;

public class ClassB extends ClassA {
    public ClassB(int a){
        this(a,0);
        System.out.println("ClassB 생성자 a = "+a);
    }

    public ClassB(int a, int b){
        super(); //기본 생성자 생략 가능
        System.out.println("ClassB 생성자 a = " + " b = " +b);
    }
}

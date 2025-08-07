package lesson_1_7_extends.overriding.Super;

public class Child extends Parent {
    public String value = "child";

    @Override
    public void hello(){
        System.out.println("child.hello");
    }

    public void call(){
        System.out.println("this.value = " + this.value); // 클래스의 자기자신 맴버 변수
        System.out.println("super.value = " + super.value); // 부모클래스에서의 값

        this.hello();
        super.hello();
    }
}

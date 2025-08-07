package lesson_1_7_extends.overriding.child;

import lesson_1_7_extends.overriding.parents.Parent;

public class Child extends Parent {
    public void call(){
        publicValue = 1; // public이라 부모 에서 접근 가능
        protectedValue = 1; // protected 상속관계 or 같은 패키지라 접근 가능
        //defaultValue = 1; // 다른 패키지라 접근 불가
        //privateValue = 1; // 같은 클래스내에서만 접근 가능

        publicMethod(); // public 상속이라 부모로부터 접근 가능
        protectedMethod(); // 상속관계 or 같은 패키지라 접근 ㅏ능
        //defaultMethod() // 역시 접근 불가
        //privateMethod // 접근 불가 ,컴파일 오류

        printParent();
    }
}

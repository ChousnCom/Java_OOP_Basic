package lesson_1_8_polymorphism.poly;

public class PolyMain {
    public static void main(String[] args) {

        //부모 변수가 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.ParentMethod();

        //자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        child.ParentMethod();

        //부모 변수가 자식 인스턴수 참조(다형적 참조)
        System.out.println("Parent -> Child");
        Parent poly = new Child();
        poly.ParentMethod();

        //Child child1 = new Parent(); // 자식은 부모를 품을 수 없음
        //poly.childMethod(); //자식을 품으나, 자식의 기능은 호출 할 수 없음.

        // 1. 다형적 참조에서 부모는 자식을 품을 수 있음.
        // 2. 다형적 참조시 자식은 부모를 담을 수 없음.
        // 3. 다형적 참조시 부모는 자식을 품을 수 있으나, 자식의 기능은 호출 불가.

    }
}

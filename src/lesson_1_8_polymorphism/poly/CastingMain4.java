package lesson_1_8_polymorphism.poly;

public class CastingMain4 {
    public static void main(String[] args) {

        //업 캐스팅은 자동이지만 다운캐스팅은 자동으로 하면 안되는 이유.
        Parent parent1 = new Parent();
        Child child1 = (Child) parent1;
        child1.ParentMethod();

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2;
        child2.ParentMethod(); // 실행 불가 -> ClassCastException.
    }
}

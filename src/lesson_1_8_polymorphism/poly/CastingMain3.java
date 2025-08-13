package lesson_1_8_polymorphism.poly;

public class CastingMain3 {
    public static void main(String[] args) {
        Child child = new Child();

        //upCasting.
        Parent parent1 = (Parent) child;
        Parent parent2 = child;

        parent1.ParentMethod();
        parent2.ParentMethod();
    }
}

package lesson_1_4_generator.constructor;

public class MemberConstructor {
    String name;
    int age;
    int grade;


    //생성자 오버로딩
//    MemberConstructor(String name, int age) {
//        this.name = name;
//        this.age = age;
//        this.grade = 50;
//    }

    MemberConstructor(String name, int age){
        this(name,age,50);
    }


    MemberConstructor(String name, int age, int grade) {
        System.out.println("생성자 호출 : name = " + name + ", age = " + age + ", grade = " + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}


package lesson_1_ClassandData;

public class ClassStart4 {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "학생1";
        student1.age = 23;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name="학생2";
        student2.age = 23;
        student2.grade = 90;

        Student [] students = {student1,student2};
        students[0] = student1;
        students[1] = student2;

        System.out.println("이름 : " + students[0].name + " 나이 : " + students[0].age + "성적 : " + students[0].grade);
        System.out.println("이름 : " + students[1].name + " 나이 : " + students[1].age + "성적 : " + students[1].grade);

    }
}

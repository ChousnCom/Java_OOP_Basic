package lesson_1_4_generator.constructor;

public class MethodInitMain1 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        member1.name = "user";
        member1.age = 15;
        member1.grade = 20;

        MemberInit member2 = new MemberInit();
        member2.name = "user2";
        member2.age = 16;
        member2.grade = 80;

        MemberInit[] members = {member1, member2};
        for (MemberInit member : members) {
            System.out.println("member = " + member.name + " " + member.age + " " + member.grade);
        }

    }
}

package lesson_1_6_final.solution;

public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member("myId","kim");
        member.print();
        member.changeData("myId2","seo"); //값이 변경 안됨을 확인
        member.print();
    }
}

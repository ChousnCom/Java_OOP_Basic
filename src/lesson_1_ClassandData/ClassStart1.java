package lesson_1_ClassandData;

public class ClassStart1 {
    public static void main(String[] args) {
        String studentName = "학생1";
        int studentAge = 15;
        int studentGrade = 90;

        String student2Name ="학생2";
        int student2Age = 18;
        int student2Grade = 90;

        System.out.println("이름 : " + studentName + " 나이 : " + studentAge + " 성적 : " + studentGrade);
        System.out.println("이름 : " + student2Name + " 나이 : " + student2Age + " 성적 : " + student2Grade);
    }
}
//학생 2명 이상을 다루기 위해 각각 다른 변수 사용.
// 학생이 그 이상으로 늘어난다면 그때마다 변수를 추가 선언 및 출력 코드 추개하야 하는 문제 발생
// 배열로 해결 가능

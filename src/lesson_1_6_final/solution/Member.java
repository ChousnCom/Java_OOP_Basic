package lesson_1_6_final.solution;

public class Member {
    private final String id;
    private String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public void changeData(String id, String name){
        //this.id = id; -> 값 변경 불가 final 값이라 생성자에서 id를 초기화 하고 난 시점에서는 더는 값 할당 불가함.
        this.name = name;
    }
    public void print(){
        System.out.println(" id  = " + id + " name: " + name);
    }

}

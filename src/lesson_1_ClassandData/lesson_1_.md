# 1. 클래스와 데이터

```java
  public class ClassStart1 {
      public static void main(String[] args) {
          String student1Name = "학생1"; int student1Age = 15;
          int student1Grade = 90;
       
            String student2Name = "학생2"; int student2Age = 16;
            int student2Grade = 80;
        
            System.out.println("이름:" + student1Name + " 나이:" + student1Age + " 성 적:" + student1Grade);
            System.out.println("이름:" + student2Name + " 나이:" + student2Age + " 성 적:" + student2Grade);
        } 
}
```
#### 변수를 사용한 예제 : 문제는 데이터가 추가될수록 그에 맞게 변수 및 출력부도 계속 추가되어야 한다는 문제가 존재

```java

  public class ClassStart2 {
    public static void main(String[] args) {
    String[] studentNames = {"학생1", "학생2"}; int[] studentAges = {15, 16};
    int[] studentGrades = {90, 80};
    
    for (int i = 0; i < studentNames.length; i++) { System.out.println("이름:" + studentNames[i] + " 나이:" +
    studentAges[i] + " 성적:" + studentGrades[i]); }
    } 
}
```

#### 배열을 도입해서 해당 문제를 해결 -> 학생이 추가 될때 마다 변수는 추가하지 않아도 되지만, 수정하기 어려움. 데이터 수정이나 삭제를 할때, 원하는 데이터를 정확하게 찾아서 수정이나 삭제를 해야함.

#### 컴퓨터는 상관없지만 -> 사람이 유지보수하기에는 어려운 코드임.

#### 이름,나이,성적을 지금처럼 따로 나누어서 관리하는 것은 좋은 방식이 아님
#### 사람이 관리하기 좋은 코드는 학생이란 개념을 하나로 묶어 각 학생에 맞는 정보를 관리하는 것임.

## 클래스 도입
```java
public class Student{
    String name;
    int age;
    int grade;
}
```
#### class 키워드를 사용해서 학생 클래스를 정의
#### 이때 클래스 안에서 정의 변수들은 == 멤버 변수 혹은 필드라고 지칭.
#### 클래스는 관례상 대문자이며 카멜 표기법을 사용함

## 클래스 사용법
```java
Student student = new Student(); //객체 생성
student.name = "학생1";
student.age = 18; //인스턴스
student.grade = 90;
```
#### new 연산자를 통해 객체를 생성하고 .연산자를 통해 생성된 객체(인스턴스)에 접근 가능
#### 클래스를 사용하게 되면 데이터 타입을 사용자가 직접 정의할 수 있게 되며, 클래스는 데이터 타입을 만드는 일종의 설계도.
#### 셀계도인 클래스를 이용하여 실제 메모리에 만들어진 실체를 객체 or 인스턴스라 지칭

```java
Student student = new Student(); // 참조값 반환
student = //참조값 보관. 
//참조값이 x001이라면
student=//x001; new시점에서 보관하고 있게됨.
```
#### student는 이제 참조값을 가지고 있으므로 해당 변수를 통해 실제 객체에 접근하고 사용가능.  '.' 을 통해서

## 정리
#### 객체 : 클래스에서 정의한 속성과 기능을 가친 실체 -> 객체는 서로 독립r적인 상태
```java
Student student1 = new Student(); //x001
Student student2 = new Student(); //x002
```
#### 같은 클래스를 공유하지만 서로 다른 참조값을 지님 -> 서로 다른 객체임

#### 이렇게 생성된 student1,student2와 같이 특정 클래스로 부터 생성된 객체를 == 인스턴스라 부름.

### 따라서 클래스는 사람 관점에서 유지보수하기 쉽기때문에 데이터타입을 직접정의해서 사용한다 볼 수 있음.

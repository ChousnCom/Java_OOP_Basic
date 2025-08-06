# -생성자

```java
     MemberInit member1 = new MemberInit();
        member1.name = "user";
        member1.age = 15;
        member1.grade = 20;

        MemberInit member2 = new MemberInit();
        member2.name = "user2";
        member2.age = 16;
        member2.grade = 80;
```
#### 예시를 들어 회원 객체를 생성하고 나면 각 회원마다 객체를 생성하여 초기값을 초기화 시켜줘야 함
#### 해당 코드에는 초기값을 설정하는 부분이 계속 반복 됨.

```java
 static void initMember(MemberInit member, String name, int age, int grade){
        member.name = name;
        member.age = age;
        member.grade = grade;
    }
    
   initMember(member1, "user1",15,90);

        MemberInit member2 = new MemberInit();
        initMember(member2, "user2",16,80);
```
#### 메서드를 통해서 반복을 제거 했음 -> 객체 지향을 학습했다면 이런 경우에는 속성과 기능을 한 곳에 두는 것이 더 좋은 방법
#### 따라서 MemberInit에서 메서드를 제공 하는 것이 더 좋은 방법;.

````java
public class MemberInit {
    String name;
    int age;
    int grade;

    void initMember(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
````
# -this

#### 위 클래스 처럼 멤버 변수의 이름과 매개변수의 이름이 같으면 구분을 어떻게 할 수 있을까?
#### 해당 메서드의 경우 매개변수가 코드 블럭의 더 안쪽에 있기 때문에 우선순위를 가짐 해당 메서드 안에서 그냥 name 을 적을 경우, 매개변수의 name에 접근하게 됨.
#### 이런 경우 멤버변수에 접근하려면 this 라는 키워드를 사용하면 됨. -> 여기서 this는 자신의 참조값을 가리킴.

```java
  void initMember(String name, int age, int grade) {
        this.name = name; // == x001.name = name;
        this.age = age; 
        this.grade = grade;
    }
}
```
#### Member member1 의 참조값이 x001이라 가정 하였을때, 메서드로 this는 자신의 참조값을 뜻하기 때문에, 해당 인스턴스의 멤버 변수에 접근 가능
#### 여기서 this 키워드를 삭제 하면, 둘다 매개변수를 가리키게 되므로 값의 변경이 일어나지 않음

# -this 생략
#### 매개변수와 멤버변수의 이름이 다르면 this 생략 가능

# -생성자 도입
#### 프로그램을 하다보면 객체 생성 직후 초기값을 할당해야하는 경우가 많음, 이때 생성자가 없다면 initMember와 같은 메서드를 매번 만들어야 함
```java
 MemberConstructor(String name, int age, int grade) {
        System.out.println("생성자 호출 : name = " + name + ", age = " + age + ", grade = " + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
```
#### 생성자는 메서드와 비슷하지만 반드시 클래스 명과 같아야 함. 따라서 첫 글자도 대문자로 시작함
#### 생성자는 반환타입이 없음 -> 비워두어야 함
#### 나머지는 메서드와 동일.

#### 생성자는 인스턴스를 생성하고 나서 즉시 호출, -> 생성자를 호출하는 방법은 다음과 같음
```java
new 생성자이름(생성자에 맞는 인수 목록); 
new 클래스이름(생성자에 맞는 인수 목록);
```

# -생성자의 장점?
```java
//생성자 등장 전
MemberInit member = new MemberInit(); member.initMember("user1", 15, 90);
//생성자 등장 후
MemberConstruct member = new MemberConstruct("user1", 15, 90);
```
#### 생성자를 쓰지 않을때는 인스턴스를 호출하고 한번더 메서드에서 초기화 해야하므로 번거롭지만, 생성자 도입시점에서는 인스턴스 생성 시점에서 객체 생성 및 할당을 동시에 처리 가능해짐.

### 장점2. 적절한 제약
#### 만약 initMember를 실수로 호출하지 않으면? -> 작동은 되나 회원의 값이 없는 유령회원 형태로 동작하게 될 것.
#### 만약 해당 값들이 시스템을 운영하기 위한 필수 값이었다면, 치명적임.

#### 생성자는 객체를 생성할때 직접 정의한 생성자가 존재한다면 -> 해당 생성자를 반드시 호출해야만 함. 호출하지 않으면 컴파일 에러.
```java
MemberConstruct member3 = new MemberConstruct(); //컴파일 오류 발생 member3.name = "user1";
```
#### 생성자는 메서드 오버로딩 처럼 여러개 정의 가능 -> 이 경우에는 필요한 생성자 하나만 호출하면 됨.

### 생성자를 사용하면 필수값 입력을 보장 받을 수 있음 -> 좋은 프로그램은 적절한 제약이 있는 프로그램

# -기본 생성자
```java
public class MemberInit {
    String name;
    int age;
    int grade; }

public class MethodInitMain1 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit(); // 이 경우에는 기본생성자를 생성 해준 것.
     }
}
```
#### 위처럼 매개변수가 없는 생성자를 기본 생성자라 지칭,
#### 클래스에 생성자가 하나도 존재하지 않다마녀 자바 컴파일러는 매개변수가 없고 아무런 코드가 없는 기본 생성자를 자동으로 생성
#### 사용자가 정의한 생성자가 하나라도 있다면 컴파일러는 기본 생성자를 만들지 않음.

### 1.생성자는 반드시 호출되어야 함.
### 2.생성자가 없으면 기본생성자가 제공
### 3.생성자가 하나라도 있다면, 기본 생성자 제공x, 이 경우 개발자가 정의한 생성자를 직접 호출해야 함.

# -생성자 오버로딩과 this()
```java
  MemberConstructor(String name, int age) {
    this.name = name;
    this.age = age;
    this.grade = 50;
}


MemberConstructor(String name, int age, int grade) {
    System.out.println("생성자 호출 : name = " + name + ", age = " + age + ", grade = " + grade);
    this.name = name;
    this.age = age;
    this.grade = grade;
}

MemberConstructor member1 =new MemberConstructor("user1",15,90);
MemberConstructor member2 = new MemberConstructor("user2",16);
```
#### 생성자의 인자 개수를 달리 하여 메서드 오버로딩처럼 생성자도 오버로딩이 가능함, 오버로딩한 생성자에서는 매개변수는 2개 grade는 생성자 안에서 직접 설정.
#### 오버로딩 덕에 성적 입력이 꼭 필요한 경우에는 해당 매개변수가 있는 생성자를 호출하면 되지만, 그렇지 않은 경우에는 없는 생성자를 호출 하면 됨.

# -this()

#### this()를 사용하면 생성자 내부에서 자신의 생성자를 호출할 수 있음 -> this는 자신의 참조값을 가리킴.
#### 즉, this() 자신의 생성자를 호출한다고 생각하면 됨.
```java
 MemberConstructor(String name, int age){
        this(name,age,50);
    }
```
#### 결과는 위에서 오버로딩 한 것과 똑같이 동작. -> this()를 사용하면 생성자 내부에서 다른 생성자를 호출 할 수 있으며, 잘 활용하게 되면 지금과 같이 중복을 제거 가능.

# -this() 규칙

#### this()는 생성자의 코드 첫 줄에만 작성 가능.




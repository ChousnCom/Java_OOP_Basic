# -자바 메모리 구조

#### 자바의 메모리 구조 ==> 메서드 영역, 스택 영역, 힙 영역
### 메서드 영역 : 클래스 정보를 보관 -> 이 클래스 정보가 붕어빵 틀과 같음
### 스택 영역 : 실제 프로그램이 실행되는 영역. 메서드를 실행할 때 마다 하나씩 샇임.
### 힙 영역 : 인스턴스가 생성되는 영역 new 명령어를 사용하면 이 영역을 사용.

#### 메서드 영역 : 프로그램을 실행하는데 필요한 공통 대이터 관리.
#### 해당 영역은 프로그램의 모든 영역에서 공유,
#### - 클래스 정보 : 클래스의 실행 코드, 필드, 메서드와 생성자 코드 등은 모든 샐행 코드가 존재.
#### - static 영역 : static 변수들을 보관
#### - 런타임 상수 풀: 프로그램을 실행하는데 필요한 공통 리터럴 상수를 보관하게 됨.
#### ex). "hello" 라는 리터럴 문자가 있으면 이런 문자를 공통으로 묶어서 관리. 이 외에도 프로그램을 효율적으로 관리하기 위한 상수들을 관리
#### (참고로 문자열을 다루는 문자열 풀은 자바 7부터 힙 영역으로 이동).

#### 스택 영역 : 자바 실행 시, 하나의 실행 스택 생성-> 각 스택 프레임은(지역 변수, 중간 연산 결과, 메서드 호출 정보등을 포함.)
#### 스택 프레임 : 메서드를 호출 할 때마다 스택 프레임이 쌓이고, 메서드 종료시 해당 스택 프레임 제거
#### 힙 영역 : 인스턴스와 배열이 생성되는 영역 -> GC가 이뤄지는 주요 영역 -> 더 이상 참조되지 않는 객체를 제거.

#### 특정 클래스로 인스턴스 생성시 힙 메모리에 인스턴스가 생성 -> 각 인스턴스는 서로 다른 변수와 메서드를 지님.
#### 인스턴스 내부 변수 값은 서로 다를 수 있지만, 매서드는 공통된 코드를 공유.
#### 따라서, 객체가 생성될때에는 인스턴스 변수에는 메모리가 할당 되지만, 메서드는 메서드 영역에서 공통으로 관리되므로 -> 메서드에 대한 새로운 메모리 할당은 없음.
### 즉, 인스턴스의 메서드를 호출한다면 -> 메서드 영역에 있는 코드를 불러서 수행.

# -스택 영역
```java
public class JavaMemoryMain1 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(10);
        System.out.println("main end");
    }
    static void method1(int m1) {
        System.out.println("method1 start");
        int cal = m1 * 2;
        method2(cal);
        System.out.println("method1 end");
    }
    static void method2(int m2) {
        System.out.println("method2 start");
        System.out.println("method2 end");
    }
}
```
#### 실행 결과.
```java
main start
method1 start
method2 start
method2 end
method1 end
main end
```
## 호출 순서.
#### main 시작 -> method1 호출 -> method2 -> 호출 -> method2 스택프레임 제거 -> method1 종료 및 스택 프레임 제거 -> main 종료 및 프로그램 종료.

### 자바는 스택 영역을 사용해서 메서드 호출과 지역 변수를 관리.
### 메서드를 계속 호출하면 스택 프레임이 계속 쌓임.
### 지역 변수(매개변수 포함) -> 스택 영역에서 관리.
### 스택 프레임이 종료 되면 지역 변수도 소멸.
### 스택 프레임이 모두 사라지면 프로그램도 종료.

# -static
```java

  public class Data1 {
      public String name;
      public int count;
      public Data1(String name) {
          this.name = name;
          count++;
    } 
}
  public class DataCountMain1 {
      public static void main(String[] args) {
          Data1 data1 = new Data1("A");
          System.out.println("A count=" + data1.count);
          Data1 data2 = new Data1("B");
          System.out.println("B count=" + data2.count);
          Data1 data3 = new Data1("C");
          System.out.println("C count=" + data3.count);
      }
  }
```
#### 실행 결과
```java
  A count=1
  B count=1
  C count=1
```
#### 해당 코드는 원래 값을 하나씩 증가 시키는 동작을 하면 원래는 A =1 B=2 C=3 이 나왔어야 했지만 기대하는대로 나오지 않음.

#### 객체를 생성할 때 마다 Data1의 인스턴스는 새로 만들어지게 되는데, 이때 그 인스턴스에 포함된 count 변수 또한 새로 만들어지기 때문.
#### 즉, 인스턴스에 사용되는 멤버변수 count는 서로 공유되지 않고 객체 생성 시점에서 매번 초기화 되기때문에 원하는 값을 얻을 수 없음.

### Sol. 외부 인스턴스에 카운트 저장하기.
```java
public class Counter {
    public int count;
}

public class DataCountMain2 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Data2 data1 = new Data2("A",counter);
        System.out.println("A count=" + counter.count);
        Data2 data2 = new Data2("B",counter);
        System.out.println("B count=" + counter.count);
        Data2 data3 = new Data2("C",counter);
        System.out.println("C count=" + counter.count);
    }
}

//결과
A count=1
B count=2
C count=3
```
#### 외부 인스턴스에 카운트 값을 따로 둠으로써, 각 객체가 생성될떼마다, count 값이 초기화 되지 않고 누적 됨.
#### -> 힙영역에 서로다른 참조값을 지닌 인스턴들이 각기 생성되기 때문에 가능한 일.

#### 문제는 Data2 클래스에서 발생한 이벤트를 한 클래스에서 처리하지 못하고 별도의 외부 클래스를 추가해서 사용해야 하므로 복잡해짐

# -static 변수 사용.
```java
public class Data3 {
    public String name; //인스턴스 변수
    public static int count; // 클래스 변수

    public Data3(String name) {
        this.name = name;
        count++;
    }
}
//출력 결과
A count=1
B count=2
C count=3
```
#### static이 붙으면 멤버 변수 count는 인스턴스 영역이 아닌 메서드 영역에서 생성 및 관리
#### 메서드 영역은 모든 프로그램에서 공유되기 때문에, count변수는 힙 영역이 아닌 메서드 영역에 따로 생성되기 때문에 값이 변하지 않고 정적으로 증가 가능.

## 용어 정리

#### 인스턴스 변수 : static이 붙지 않은 멤버 변수,
#### 클래스 변수 : static이 붙은 멤버 변수 == 클래스 변수 == static변수 == 정적 변수
#### static 변수는 인스턴스와 무관하게 클래스에 바로 접근해서 사용할 수 있고 -> 클래스 자체에 소속되어있기 때문에 클래스 변수라 지칭


# -변수와 생명 주기
#### 지역 변수 : 메서드가 종료 되면 스택프레임 제거 -> 이때 지역변수도 같이 제거 -> 생명 주기가 가장 잛음.
#### 인스턴스 변수 : 힙 영역은 GC가 발생하기 전까지는 생존하기 때문에 보통 지역 변수보다 생존 주기가 김
#### 클래스 변수 : jvm 종료 될때 까지 -> 가장 긴 생명 주기

```java
System.out.println(Data3.count);
```
#### 정적 변수는 == 클래스 변수 -> 클래스에서 공용으로 관리하기 때문에 클래스를 통해 접근하는 것이 더 명확함.

# -static 주의 사항
```java
public class DecoData {
      private int instanceValue;
      private static int staticValue;
      public static void staticCall() {
                                    //instanceValue++; //인스턴스 변수 접근, compile error //instanceMethod(); //인스턴스 메서드 접근, compile error
        staticValue++; //정적 변수 접근
        staticMethod(); //정적 메서드 접근 }
        public void instanceCall() { instanceValue++; //인스턴스 변수 접근 instanceMethod(); //인스턴스 메서드 접근
            staticValue++; //정적 변수 접근
            staticMethod(); //정적 메서드 접근 }
      private void instanceMethod() {
          System.out.println("instanceValue=" + instanceValue);
      }
      private static void staticMethod() {
          System.out.println("staticValue=" + staticValue);
      }
}
```
#### 클래스 내부의 기능 사용시, 정적 메서드는 static이 붙은 정적 메서드나 정적 변수만 사용 가능.
#### 클래스 내부의 기능을 사용할 때, 정적 메서드는 인스턴스 변수나, 인스턴스 메서드를 사용 불가함.

#### 그러나 접근 제어만 허락한다면 클래스를 통해 모든 곳에서 static 호출 가능.

### 정적 메서드가 인스턴스의 기능을 이용할 수 없는 이유는 -> 인스턴스처럼 참조값의 개념이 있는것이 아니기 때문.

### static이 자주 쓰인다면 static import!

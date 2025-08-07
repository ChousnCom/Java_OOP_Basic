# -상속

```java
public class ElectricCar {
    public void move(){
        System.out.println("차를 이동");
    }

    public void charge(){
        System.out.println("충전");
    }

    public class GasCar {
        public void move(){
            System.out.println("차를 이동");
        }

        public void fillUp(){
            System.out.println("기름 주유");
        }
    }
    public static void main(String[] args) {
        ElectricCar eCar =  new ElectricCar();
        eCar.move();
        eCar.charge();

        GasCar gas = new GasCar();
        gas.move();
        gas.fillUp();
    }
```
#### 전기차와 가솔린차의 이동과 충전을 하는 메서드를 구현하였다. 충전 방식은 다르나, 두 클래스의 공통적인 메서드가 보인다.
#### 바로 move()메서드이다. 전가차와 가솔린차를 포괄하는 더 상위의 개념의 단어 Car가 존재한다.
#### 이러한 경우 상속 관계를 이용하는 것이 효과적.

# -상속관계

### 기존 클래스의 필드와 메서드를 새로운 클래스에서 재사용하게 해줌 -> 기존 클래스의 속성과 기능을 그대로 물려 받는 것.
#### 상속을 사용하려면 extends 키워들 사용하면 되고, 자바에서는 상속(extends)대상은 하나만 선택 가능하다.

### 부모 클래스(슈퍼 클래스) : 상속을 통해 자신의 필드와 메서드를 다른 클래스에 제공.
### 자식 클래스(서브 클래스) : 부모 클래스로부터 필드와 메서드를 상속 받는 클래스.

```java
public class Car {
    public void move(){
        System.out.println("차를 이동 합니다.");
    }
}

public class ElectricCar extends GasCar {
    public void charge() {
        System.out.println("충전");
    }
}

public class GasCar extends Car{
    public void fillUp(){
        System.out.println("기름 주유");
    }
}


public class CarMain {
    public static void main(String[] args) {
        ElectricCar eCar =  new ElectricCar();
        eCar.move();
        eCar.charge();

        GasCar gas = new GasCar();
        gas.move();
        gas.fillUp();
    }
}
```
#### 상속을 받은 덕분에 다른 자동차들에서 move메서드를 직접 선언하지 않아도 부모 클래스인 Car의 move() 메서드를 사용할 수 있게 되었다.
#### 상속은 부모기능을 자식이 물려받는 것이라서, 부모 클래스는 자식 클래스에 대한 정보가 없지만. 자식은 부모에 클래스에 대한 기능을 extends를 통해 알고 있음.

### 참고로 자바는 다중 상속을 지원하지 않는다. (단일 상속만)

# -싱속시 메모리 구조

```java
ElectricCar electricCar = new ElectricCar();
```
#### electricCar 의 참조값이 = x001라 가정 했을때, new 를 통해 호출시 ElectricCar 뿐만 아니라 상속관계에 있는 Car까지 함께 포함해 인스턴스를 생성하게 됨.
#### 참조값은 하나이지만 실제로는 -> Car, ElectricCar라는 두가지 클래스 정보가 존재.
```java
electricCar.charge() 호출
```
#### 상속 관계의 경우에는 내부에 부모와 자식이 모두 존재함. 이때 부모에서 charge() 메서드를 찾을지 ElectricCar를 통해서 찾을 지 택해야함.
#### 이때는 호출하는 변수의 타입(클래스의 타입)을 기준으로 선택함. 따라서 electricCar 타입이므로, electricCar.charge()를 호출하게 됨.

#### 이와는 반대로 본인타입에서 존재 하지 않는 매서드라면 부모타입으로 올라가서 찾는다.
#### 만약 상위 부모에서도 해당 기능이 없으면 더 상위의 부모로 올라가서 찾다가, 없으면 컴파일 오류가 발생.

### 상속관계의 객체를 생성하면 부모와 자식이 모두 생성됨
### 상속관계의 객체를 호출시, 대상 타입을 정해야 하며, 호출자의 타입을 통해 대상 타입을 찾음.
### 현재 타입에서 기능을 찾지 못하면 상위 부모 타입으로 기능을 찾아서 실행함 -> 기능이 없다면? : 컴파일 에러.

# -상속과 메서드 오버라이딩
### 메서드 오버라이딩 == 부모에게서 상속 받은 기능을 자식이 재정의 하는 것을 메서드 오버라디잉이라 지칭.

```java
public class ElectricCar extends Car {
    public void charge() {
        System.out.println("충전");
    }

    @Override
    public void move(){
        System.out.println("차가 빠르게 이동 합니다.");
    }
}
```
#### 실행 결과는 오버라이딩 된 메서드가 출력된다. electricCar.move()를 호출시.

## -오버라이딩과 메모리 구조
### 1. electricCar.move() 호출
### 2. ElectricCar 타입이므로 인스턴스 내부의 ElectricCar 타입에서 부터 해당 메서드가 존재하는지 탐색
### 3. 해당 타입에 move()메서드가 존재하므로 해당 매서드를 실행 -> 이미 매서드를 찾았으므로 더 이상 부모타입에서 찾지 않음.

## 오버라이딩 조건
#### 1. 메서드 이름이 같아야함.
#### 2. 매서드의 매개변수의 타입,순서,개수가 같아야 함.
#### 3. 반환타입이 같아야 함. (이때 반환타입은 하위 클래스 타입 일 수 있음)
#### 4. 접근 제어자 : 상위 클래스의 접근제어자 보다 더 제한적이면 안됨. ex), protected 라면  private or default 이면 안됨.
#### 5. 상위 클래스의 메서드보다 더 많은 체크 예외를 던지면 안됨.
#### 6. static, final, private는 오버라이딩 될 수 없음.
#### - static 은 클래스 레벨에서 작동하므로 인스턴스 레벨에서 사용하는 오버라이딩이 의미 없음
#### - final 메서드는 재정의를 금지한다.
#### - private메서드는 해당 클래스에서만 접근 가능하기 때문에 하위클래스를 보이지 않음.
#### - 생성자는 오버라이딩 불가.

# -접근 제어자와 상속
```java
public class Parent {
    public int publicValue;
    protected int protectedValue;
    int defaultValue;
    private int privateValue;

    public void publicMethod() {
        System.out.println("Parent.publicMethod()");
    }

    protected void protectedMethod() {
        System.out.println("Parent.protectedMethod()");
    }
      void defaultMethod() {
        System.out.println("Parent.defaultMethod()");
    }
    private void privateMethod() {
        System.out.println("Parent.privateMethod()");
    }

    public void printParent(){
        System.out.println("==== Parent 메서드 안===");
        System.out.println("publicValue = " + publicValue);
        System.out.println("protectedValue = " + protectedValue);
        System.out.println("defaultValue = " + defaultValue);
        System.out.println("privateValue = " + privateValue);

        defaultMethod();
        protectedMethod();
        //privateMethod();
        //publicMethod();
    }

}
```

```java
public class Child extends Parent {
    public void call(){
        publicValue = 1; // public이라 부모 에서 접근 가능
        protectedValue = 1; // protected 상속관계 or 같은 패키지라 접근 가능
        //defaultValue = 1; // 다른 패키지라 접근 불가
        //privateValue = 1; // 같은 클래스내에서만 접근 가능

        publicMethod(); // public 상속이라 부모로부터 접근 가능
        protectedMethod(); // 상속관계 or 같은 패키지라 접근 ㅏ능
        //defaultMethod() // 역시 접근 불가
        //privateMethod // 접근 불가 ,컴파일 오류

        printParent();
    }
}
```

# -super() - 부모참조
#### super 키워드를 사용하면 부모를 참조할 수 있음 -> super는 부모클래스에 대한 참조를 나타냄. 부모클래스에 대한 메서드를 출력하고 싶다면 super를 사용

```java
public class Child extends Parent {
    public String value = "child";

    @Override
    public void hello(){
        System.out.println("child.hello");
    }

    public void call(){
        System.out.println("this.value = " + this.value); // 클래스의 자기자신 맴버 변수
        System.out.println("super.value = " + super.value); // 부모클래스에서의 값

        this.hello(); //오버라디이 된 메서드 출력
        super.hello(); // 부모클래스의 메서드 출력
    }
}
```

# super-생성자
#### 상속관계에서는 메모리 내부에 부모와 자식클래스가 같이 생성된다고 하였다. 모든 클래스는 생성자가 반드시 호출 되어야 하며, 생성자가 없을시에는 기본생성자를 만들어 호출 해준다 하였다.
#### 메모리에는 부모와 자식클래스가 있으므로 각각의 생성자들 모두가 호출 되어야 함.

## 상속 관계를 사용하면 자식클래스에서 반드시 부모클래스의 생성자를 호출해야한다.

```java
public class ClassA {
    public ClassA(){
        System.out.println("ClassA 생성자.");
    }
}

public class ClassB extends ClassA {
    public ClassB(int a){
        super(); // 기본생성자 생략 가능
        System.out.println("ClassB 생성자 a = "+a);
    }

    public ClassB(int a, int b){
        super(); //기본 생성자 생략 가능
        System.out.println("ClassB 생성자 a = " + " b = " +b);
    }
}

public class ClassC extends ClassB {
    public ClassC(){
        super(10,20); //B의 생성자 호출 및 매개변수 값 할당
        System.out.println("Class C 생성자");
    }
}

public class SuperMain2 {
    public static void main(String[] args) {
        ClassC c = new ClassC();
    }
}
```
#### 메인에서 호출은 classC 가 먼저 되는게 맞음.
#### ClassC 내부에서 classB의 생성자를 호출하고, B에서 classA의 생성자를 호출한다.
#### 그리고 더 이상 올라갈 생성자가 존재하지 않으므로 -> A 실행 -> B 실행 -> C실행 순으로 결과가 출력

### 상속 관계의 생성자 호출은 결과적으로 부모에서 자식 순서로 실행. 따라서 부모의 데이터를 먼저 초기화 하고 그 다음 자식 데이터를 초기화 시킴.
### 상속 관계에서 자식 클래스의 생성자 첫줄에는 반드시 super()를 호출해야함.

```java
public class ClassB extends ClassA {
    public ClassB(int a){
        this(a,0);
        System.out.println("ClassB 생성자 a = "+a);
    }

    public ClassB(int a, int b){
        super(); //기본 생성자 생략 가능
        System.out.println("ClassB 생성자 a = " + " b = " +b);
    }
}
```
#### 코드 첫줄에 this를 써도 반드시 다른 생성자에서는 super()를 한번은 호출해야함.

## 클래스에 final 이 붙으면 -> 상속이 끝1 -> final로 선언된 클래스는 확장 불가 == 상속을 받을 수 없다는 의미.
## 메서드에 final -> 오버라이딩 끝! -> final로 선언된 메서드는 오버라이드 될 수 없음. -> 상속받은 서브 클래스에서 이 메서드를 변경 불가!.

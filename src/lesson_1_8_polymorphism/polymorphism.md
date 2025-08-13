# -다형성-
## -다형적 참조-

#### 다형성이란? -? 한 객체가 여러 타입의 객체로 취급될 수 있는 능력. 보통은 하나의 객체는 하나의 타입으로 고정이지만, 다형성을 사용하면 하나의 객체가 다른 타입으로 사용 될 수 있음.


```java
public class Parent {

    public void ParentMethod() {
        System.out.println("Parent Method");
    }
}

public class Child extends Parent {

    public void childMethod() {
        System.out.println("Child Method");
    }
}

public class PolyMain {
    public static void main(String[] args) {

        //부모 변수가 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.ParentMethod();

        //자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        child.ParentMethod();

        //부모 변수가 자식 인스턴수 참조(다형적 참조)
        System.out.println("Parent -> Child");
        Parent poly = new Child();
        poly.ParentMethod();

        //Child child1 = new Parent(); // 자식은 부모를 품을 수 없음
        //poly.childMethod(); //자식을 품으나, 자식의 기능은 호출 할 수 없음.

        // 1. 다형적 참조에서 부모는 자식을 품을 수 있음.
        // 2. 다형적 참조시 자식은 부모를 담을 수 없음.
        // 3. 다형적 참조시 부모는 자식을 품을 수 있으나, 자식의 기능은 호출 불가.

    }
}
```
## case1. Parent parent = new Parent();
#### 부모가 부모타입의 인스턴스를 참조, 이 경우 매모리 상에는 Parent 인스턴스 하나만 생성 -> 자식은 생성x.

## case2. Child child = new Child();
#### 자식타입의 변수가 자식 인스턴스 참조, 이 경우 부모를 상속 받았기 때문에 메모리에는 부모,자식 인스턴스가 생성
#### child.parentMethod() 호출시, 자식타입에 해당 메서드가 없으면 더 상위 부모타입으로 올라가서 탐색, 찾으면 실행, 없으면 컴파일 에러.

## case3. Parent poly = new Child();
#### 부모 타입의 변수가 자식 인스턴스를 참조, Child를 생성했기 때문에 이 경우 메모리에 부모,자식이 모두 생성.
#### 부모는 자식을 담을 수 있으나, 반대로 자식은 부모를 담을 수 없음, 지금 경우에는 단순 자식이지만 더 하위의 손자 타입도 참조가 가능함.
```java
Parent poly = new Grandson(); //손자 타입 다형적 참조 가능 Child 하위에 손자가 있다면.
```
#### -> 자바에서는 부모타입은 물론, 자신을 기준으로 하위 자식 타입을 모두 참조 가능 (다형적 참조 가능).

```java
poly.childMethod() //호출 불가.
```
#### 다형적 참조를 통해 메모리에 자식 부모 모두가 생성되어 childMethod에도 접근하려 했더니 컴파일 오류가 난다.
#### 메모리에 자식 부모가 생성될 경우, 호출자의 타입을 기준으로 해당 메서드를 찾으려고 할 것이다.
#### poly는 Parent 타입 이므로, Parent 클래스부터 시작해 필요한 모든기능을 탐색하려 한다. 그러나, 상속관계에서는 부모 방향(위쪽)으로 찾아 올라갈 순 있으나, 자식 방향으로는 내려갈 수 없다.
#### 그렇기 때문에 자식 메서드를 찾을 수 없고, 컴파일 오류가 나게 되는것. 
#### 그럼에도 childMethod()를 호출하고 싶으면 어떻게 해야할까? -> 캐스팅이 필요할 것 같다.

# -다형성과 캐스팅-
```java
public class CastingMain1 {
    public static void main(String[] args) {
        //부모 타입은 자식 인스턴스 참조 가능(다형적 참조)
        Parent poly = new Child();

        //다운 캐스팅 시작. 부모 타입을 -> 하위 자식 타입으로
        Child child = (Child) poly;
        child.childMethod();
    }
}
```
#### 아까도 언급 했듯이 상속관걔에서는 해당 타입으로부터 더 상위로만 올라갈 수 있고, 자식인 하위타입으로는 내려갈 수 없다 하였다.
#### 이때, 부모타입인 poly의 참조값을 꺼내 잠깐 Child 타입으로 변경해 (다운캐스팅) 인스턴스의 Child에 있는 childMethod()호출 가능하다.
#### (타입 지정) -> 괄호 안에 타입을 지정하면 참조 대상을 특정 타입으로 변경 가능. == 캐스팅.
#### 참고로 캐스팅을 한다해서 poly 타입 자체가 child타입이 되는 것이 아니라, poly 타입의 참조값을 꺼내고 꺼낸 참조값이 child타입이 되는 것임.
```java
Child child = (Child) poly; // poply 자체가 child 타입이 되는것이 아님!
Child child = (Child) x001; // 꺼낸 참조값이 Child타입!
Child child = x001;// 결과
```
### -캐스팅의 종류-

#### 1. 다운 캐스팅 : 자식(하위) 타입으로 변경
#### 2. 업 캐스팅 : 부모(상위) 타입으로 변경.

```java
public class CastingMain2 {
    public static void main(String[] args) {

        Parent poly = new Child();
        //다운 캐스팅 시작. 부모 타입을 -> 하위 자식 타입으로
        Child child = (Child) poly;
        child.childMethod();
        
        //일시적 다운 캐스팅 - 메서드 호출 순간만 다운캐스팅.
        //별도의 변수 선언 없이 바로 인스턴스 자식 타입의 기능을 사용 가능.
        ((Child)poly).childMethod();
    }
}
```
#### 다운 캐스팅 결과를 변수에 담아 놓는 과정이 번거롭기 때문에. 해당 타입의 기능이 필요할때만 잠시 캐스팅을 하여, 하위 클래스의 기능을 바로 호출 가능.
#### 다시 한번 언급하지만 poly 타입 자체가 Child 타입으로 변경되는 것이 아닌 꺼낸 참조값이 -> Child타입으로 변경되는 것.


### -업캐스팅-
```java
public class CastingMain3 {
    public static void main(String[] args) {
        Child child = new Child();

        //upCasting.
        Parent parent1 = (Parent) child;
        Parent parent2 = child; //업 캐스팅은 생략 가능.

        parent1.ParentMethod();
        parent2.ParentMethod();
    }
}
```
### 다운 캐스팅 vs 업 캐스팅
#### 다운 캐스팅은 개발자가 직접 명시해야만 하지만 업캐스팅은 생략을 권장함.
```java
public class CastingMain4 {
    public static void main(String[] args) {

        //업 캐스팅은 자동이지만 다운캐스팅은 자동으로 하면 안되는 이유.
        Parent parent1 = new Parent();
        Child child1 = (Child) parent1;
        child1.ParentMethod();

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2;
        child2.ParentMethod(); // 실행 불가 -> ClassCastException.
    }
}
```
### Case parent1.
#### parent1 = new Child(); 시 메모리에 부모,자식 인스턴스가 모두 생성된다. 이럴경우 메모리 상에는 부모 자식 2개의 인스턴스가 다 존재하므로, 다운캐스팅을 통한 Child 메서드 호출이 가능.

### Case parent2.
#### parent2 = new Parent(); 시 메모리에는 Parent 인스턴스만 생성됨. -> 메모리상에는 Child가 아예 존재하지 않으므로 다운캐스팅을 통해 Child메서드에 접근 자체가 불가능함. -> 메모리에 존재하지 않기때문(Child).

### 업캐스팅이 안전하고 다운캐스팅은 위험한 이유.
```java
public class ClassTestMain {
    public static void main(String[] args) {
        ClassA A = new ClassC(); // 클래스 A 클래스 C로 업캐스팅
        ClassB B = new ClassC(); // 클래스 B 클래스 C로 업캐스팅
        ClassC C = new ClassC(); // 자기 자신과 같은 타입.

        //Method A호출.
        A.methodA(); //A.MethodA는 호출 가능 그러나, 하위 자식 타입의 메서드는 호출 불가.
        B.methodA(); //B 도 부모의 메서드인 A에 접근 가능 상속관걔.
        C.methodA(); //C 또한 메서드 A에 접근 가능.

        System.out.println();

        System.out.println("메서드 B 출력");
        //A.methodB(); -> 접근 불가 접근하려면 다운캐스팅 필요.
        ((ClassB)A).methodB(); //일시적 다운캐스팅을 통한 메서드 B 접근
        C.methodB(); // C는 B의 상속을 받고 있음 -> 부모 클래스의 메서드에 접근 가능.

        System.out.println();

        System.out.println("메서드 C 출력");
        ((ClassC)A).methodC();
        ((ClassC)B).methodC();
        C.methodC();
    }
}
```
#### -> 상속의 제일 하위 타입의 C를 기준으로 업캐스팅을 통해 생성을 한다. -> 이 경우 메모리에는 C는 물론 C의 상위 부모인 A,B 모두 메모리에 같이 생성되게 된다.
#### -> 업캐스팅을 통한 객체 생성은 본인 기준 자기보다 더 상위의 부모는 모두 메모리에 생성이 되기 때문에 별도의 명시적 캐스팅 없이 안전하게 됨.

```java
     ClassA A = new ClassB(); 
        ClassB B = new ClassB(); 
        ClassC C = (ClassC)new ClassB();// 불가.
```
#### 이번에는 classB로 업캐스팅 하는 경우이다. ClassB 로 업캐스팅하는 경우 메모리에는 A,B는 자동으로 생성될 것.
#### 그러나 문제는 C이다 C는 B의 자식이므로 C를 B로 생성을 하기위해서는 다운캐스팅을 해줘야함.
#### 하지만, 메모리상에는 A,B만 존재할 뿐 C라는 객체는 존재하지 않기때문에 다운캐스팅을 통한 접근 자체가 불가하다.

## 정리.
### 업캐스팅은 자기 자신 포함 상위 타입의 객체를 모두 메모리에 생성하기 때문에 캐스팅을 생략 가능하지만, 다운캐스팅은 개발자가 직접 명시해야함. -> 런타임 오류 예방

# -instacneof-
#### 인스턴스의 타입을 확인하고 싶다면, instanceof 키워드를 사용.
```java
public class CastingMain5 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1);

        Parent parent2 = new Child();
        System.out.println("parent2 호출");
        call(parent2);
    }
    private static void call(Parent parent) {
        parent.ParentMethod();
        if(parent instanceof Child) {
            System.out.println("Child인스턴스 맞음");
            Child child = (Child) parent;
            child.ParentMethod();
        }
    }
}
```
#### instanceof 오른쪽 타입에 왼쪽 타입이 들어 갈 수 있는지 없는지를 판단.
#### parent1 은 Parent 의 인스턴스를 참조하므로 false, parent2는 Child의 인스턴스를 참조하므로 true;


# -다형적 참조와 메서드 오버라이딩-
```java
public class OverridingMain {
    public static void main(String[] args) {

        //자식 변수가 자식 인스턴스 참조
        Child child = new Child();
        System.out.println("Child -> Child");
        System.out.println("value = " +child.value);
        child.method();

        //부모 변수가 부모 인스턴스 참조
        Parent parent = new Parent();
        System.out.println("Parent -> Parent");
        System.out.println("value = " +parent.value);
        parent.method();

        //부모 변수가 자식 인스턴스 참조.
        Parent poly = new Child();
        System.out.println("Parent -> Child");
        System.out.println("value = " +poly.value);
        poly.method();
    }
}
```
#### poly변수는 Parent타입이므로 메서드 호출시 Parent타입에서 해당 메서드가 존재하는지 찾아야 맞지마, child에서 오버라딩 된 메서드가 존재한다.
#### 이때 오버라이딩된 메서드는 항상 우선권을 지녀, 부모의 method()가 아닌, 오버라딩 된 하위의 메서드가 우선으로 호출됨.
#### 만약 child보다 더 하위의 오버라이딩 된 메서드가 존재한다면, 더 하위의 메서드가 호출되게 됨.

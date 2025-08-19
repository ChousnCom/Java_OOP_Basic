# -다형성 연장-

```java
public class AnimalSoundMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat  = new Cat();
        Caw caw = new Caw();

        dog.sound();
        cat.sound();
        caw.sound();
    }
}
//다형적 참조를 활용하지 않고 코드를 동물의 울음을 출력하는 프로그램 작성
//동물이 추가될때마다, 클래스를 만들어야 하며 각 인스턴스도 따로 계속 만들어 줘야함.
//서로 타입 또한 다르기 때문에 메서드나 배열 혹은 반복을 통한 리팩토링을 할 수 없음.
```
#### 다형성의 핵심은 다형적 참조와 메서드 오버라이딩 -> 이 둘을 활용하면 Cat,Dog,Caw 모두를 같은 타입을 사용하게 하고, 각자의 메서드를 호출하게 만들 수 있음.

```java
public class AnimalPolyMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);
    }
    private static void soundAnimal(Animal animal){
        System.out.println("소리 테스트");
        animal.sound();
    }
    
    public class Animal {
        public void sound(){
            System.out.println("동물 울음 소리");
        }
    }

    public class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("야옹");
        }
    }

}
```
#### 다형적 참조와 메서드 오버라이딩을 활용한 예시, 다형적 참조와 메서드 오버라이딩 덕분에 세 인스턴스를 하나의 타입으로 묶고, 메서드를 통해 코드를 간소화 할 수 있었음.
```java
public class AnimalPolyMain2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        Animal [] animals = {dog,cat,caw};

        for(Animal animal : animals){
            System.out.println("동물 소리");
            animal.sound();
        }
    }
}
```

#### 또한 같은 데이터 타입으로 묶는 것이 가능해졌기 때문에 배열 및 반복문을 통한 코드간소화도 가능해짐.
```java
public class AnimalPolyMain3 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        Animal [] animals = {dog,cat,caw};
        for(Animal animal : animals) {
            soundAnimal(animal);
        }
    }
    private static void soundAnimal(Animal animal){
        System.out.println("동물 소리");
        animal.sound();
    }
}
```
#### 최종 리팩토링 결과. 기존 코드와는 달리 다형적 참조 덕분에 앞으로는 새로운동물이 추가 되더라도 Animal을 상속받은 클래스 하나와 객체만 생성해주면 됨. 
#### 이렇게 리팩토링이 진행되었지만, 남은 문제는 Animal 클래스를 생성해버리는 문제, 자식에서 오버라이딩 하지않을 가능성이 존재함.

#### Animal은 서로다른 동물의 타입을 묶기위한 껍데기일 뿐 직접 Animal을 생성해 사용할 일이 있을까?
#### 만약 개발자가 실수로 하위 개념에서 메서드를 오버라이딩 하지 않았다면? -> 부모의 메서드가 호출되어 난처해짐.

### 메서드를 오버라이딩 하지않을 가능성, 부모 클래스를 직접 생성하여 사용하는 경우를 방지해주는 것이 바로 추상 클래스.

# -추상클래스-
#### Animal과 같이 실제로 생성되면 안되는 클래스를 추상 클래스라 지칭.
#### 추상클래스는 부모 클래스는 제공하지만, 실체인 인스턴스는 존재하지 않음. -> 상속 목적으로만, 부모 클래스 역할을 담당.

```java
abstract class AbstractAnimal {...}
```
#### 위와 같이 클래스 앞에 abstract 키워드를 붙혀주면 됨.
#### 이렇게 추상클래스로 등록함으로써, new 를 통한 객체생성을 막는다.

```java
public abstract void sound();
```
#### 마찬가지로 메서드 앞에 abstract 키워드가 들어가면 추상메서드.
#### 추상 메서드는 추상적인 개념만을 제공하는 메서드로, 구현부가 존재하지 않고 껍데기만 존재함.
#### 추상메서드가 하나라도 있다면 해당 클래스는 반드시 추상클래스로 선언해야함 -> 안그러면 컴파일 에러.
#### 추상메서드는 반드시 상속받는 자식 클래스가 오버라이딩 해서 사용해야 함.

### 추상매서드가 하나라도 있다면 -> 반드시 추상 클래스로
### 추상클래스는 생성이 불가.
### 추상메서드는 상속을 받는 자식쪽에서 반드시 오버라딩해서 사용해야 함.
```java
public class AbstractMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw  = new Caw();

        cat.sound();
        cat.move();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);

    }
    private static void soundAnimal(AbstractAnimal animal){
        animal.sound();
    }
}
```
#### 추상 클래스를 적용서 구현.
#### 추상메서드가 아닌 메서드는 반드시 오버라딩 할 필요 없음.
#### 추상메서드로 선언되었다면 반드시 오버라딩 해야함 -> 아니라면 컴파일 에러
#### 추상클래스 생성을 시도하면 -> 추상클래스는 생성할 수 없다고 나옴.

```java

  public abstract class AbstractAnimal {
      public abstract void sound();
      public abstract void move();
}
```
#### 이렇게 모든 메서드가 추상 메서드로 구현되어있으면 이는 순수 추상클래스임
#### 상속받는 하위(자식)에서 모든 메서드를 반드시 오버라딩해야함.

#### 순수 추상 클래스(추상클래스)는 인스턴스를 생성할 수 없음
#### 순수 추상 클래스를 상속시 모든 메서드를 반드시 오버라이딩 해야 함.
#### 순수 추상 클래스는 주로 다형성을 위해 사용 됨.

# -interface-
#### 자바에서는 이러한 순수 추상클래스를 좀 더 편리하게 사용하게 하기 위해 인터페이스 개념을 제공
```java
  public interface InterfaceAnimal {
      void sound();
      void move();
}
```
### -특징-
#### 인터페이스의 모든 메서드는 public abstract이다.
#### 인터페이스 안에서 해당 키워드는 위와 같이 생략 가능.
#### 인터페이스는 다중 구현(다중 상속)을 지원한다.

```java
 public interface InterfaceAnimal {
      public static final double MY_PI = 3.14;
}
```
#### 인터페이스 안에서의 멤버 변수는 public, static, final이 모두 포함되어 있음.
#### 이 역시 마찬가지로 세 키워드는 인터페이스 안에서 모두 생략이 가능.
```java
public interface InterfaceAnimal {
    void move(); // public abstract 가 생략
    void sound();
}
```

```java
public class Dog implements InterfaceAnimal {

    @Override
    public void move() {
        System.out.println("Dog move");
    }

    @Override
    public void sound() {
        System.out.println("Dog sound");
    }
}
```

```java
public class InterfaceMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        soundAnimal(dog);
        moveAnimal(dog);
        soundAnimal(cat);
        moveAnimal(cat);
    }
    private static void soundAnimal(InterfaceAnimal animal) {
        animal.sound();
    }

    private static void moveAnimal(InterfaceAnimal animal) {
        animal.move();
    }
}
```
#### 구조는 순수 추상클래스와 유사하다. 키워드 및 편의성이 인터페이스로 바뀌었을 뿐.
#### 부모의 클래스의 기능을 자식이 상속받을 때는, 상속이라 표현하지만, 인터페이스의 기능을 물려받을때는 구현한다라 표현
#### 상속은 다중상속이 불가능 하지만, 구현은 다중구현(상속)이 가능함.

#### 왜 인터페이스는 다중구현이 가능할까?
#### 인터페이스 자신은 구현을 가지지 않기 때문임. 껍데기만 제공하여 자식에서 반드시 오버라이딩 하게끔 되어 있는 구조.
#### 오버라이딩을 하게되면 오버라딩한 메서드가 더 우선권을 가지기 때문에, 다중 구현을 하더라도 다이아몬드 문제가 발생하지 않게 됨.
#### 즉, 구현하는 부분은 자식이기 때문에 서로다른 인터페이스에 공통 메서드가 있어도 이는 결국 구현하는 자식에서ㅏ 결정되기 때문에 다중 구현이 가능함.


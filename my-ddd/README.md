## Memo

### Entity vs Value

엔티티의 가장 큰 특징은 식별자를 갖는다는 것.(p18)
밸류 타입은 개념적으로 완전한 하나를 표현할 때 사용한다. (p22)

밸류 객체(Money)의 데이터를 변경할 때는 기존 데이터를 변경하기 보다는 변경한 데이터를 갖는
새로운 밸류 객체를 생성하는 방식을 선호한다.(p26)

Money 처럼 데이터 변경 기능을 제공하지 않는 타입을 불변(Immutable) 이라고 표현한다.(p27)

### 불변객체를 사용하는 이유?
안전한 코드를 작성할 수 있다. 만약 Money 가 setValue() 와 같은 메서드를 제공해서 값을 변경할 수 있다면?
참조투명성? 과 관련된 문제가 발생한다.(p27)

불변객체는 참조 투명성과 스레드에 안전한 특징을 갖고 있다. 불변 객체에 대해 더 많은 내용을 알고 싶다?
https://goo.gl/2Lo4pU 참고!

***

## 참고내용

### @Embeddable , @Embedded : OrderLine , ProductId 클래스 참고
JPA에서 엔티티 내에 참조클래스의 필드를 그대로 자신의 컬럼으로 만들고 싶다면?
참조클래스(ProductId)에 @Embeddable 해주고 엔티티(OrderLine) 내에는 @Embedded 해주면 된다.


### @OrderColumn(name="line_idx") : Order 클래스 참고
순서가 있는 특수한 컬렉션으로 인식하게 해준다. 순서가 있다는 의미는 데이터베이스 순서 값을 저장해서
조회할 때 사용한다는 의미.

@OrderColumn(name = "line_idx")
private List<OrderLine> orderLines;

OrderLine 클래스에선 line_idx 라는 필드가 안보인다.
DB의 order_line 테이블에 보면 line_idx 가 생긴다.

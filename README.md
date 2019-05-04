## DDD-START! 도메인 주도 설계 구현과 핵심 개념 익히기. (최범균님)
## DDD-START 예제 안내
### https://github.com/madvirus/ddd-start


### 꼭 코드를 보면서 책을 보자. 생소한 애노테이션 이 많다.
### 급하게 보지 말고 구조를 파악하면서 천천히 보자.
***
<br>


## 같이 보면 좋을 책

### 엔터프라이즈 애플리케이션 아키텍처 패턴 - 마틴 파울러
***
<br>

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




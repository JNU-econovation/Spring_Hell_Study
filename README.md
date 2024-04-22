---

기존 구성을 전체적으로 바꿨습니다.

- 상품 관리 - goods 패키지
⇒ 판매 상품을 관리하는 패키지로 스티커생성 및 데이터 추가 담당
- 주문 관리 - order 패키지
⇒ 스티커 판매 담당

printingHouse와 cityHall 패키지를 제거하고, goods 밑에 있는 Goods1과 Goods2 처럼 새로 상품이 등록될 때마다 상품 자체의 클래스를 만들어야 하는 것은 아니라는 생각이 들어 제거하고 GoodsRepository클래스를 만들어 여기에 상품 이름을 지정해주는 필드를 만들어줬습니다.

goods 패키지

- BaseGoods(interface)
※getter & 재고 설정 메서드
- GoodsRepository(interface)
※상품 저장
※Id로 검색
※Id로 해당 상품의 재고 확인
※전체 상품을 리스트 반환
- GoodsService(interface)
※상품 생성
※상품 아이디로 검색
※상품 아이디로 해당 상품 재고 확인
- GoodsSerivceImpl implements GoodsService
- NamwonGoods implements BaseGoods
- 상품Id
- 상품 이름
- 발주시 가격
- 상품 재고
- NamwonGoodsRepository implements GoodsRepository
- store 멤버(Map 타입으로 전체 상품 관리)
- GoodsController → API화
※ POST api/v1/goods
    물품 생성
※ GET api/v1/goods/{id}
    해당 물품의 재고 조회
- GoodsRank(enum)
- 프리미엄 정책에 따른 각 등급

order 패키지

- Order
판매 주문을 받을 클래스
- 상품Id
- 상품 이름
- 상품의 재고
※생성자 & getter
- OrderService(interface)
※주문 생성
※상품 판매 ⇒ (랜덤으로 판매하는 부분 구현 중)
※1인당 판매 갯수 제한(구현 중)
※공직자 할인
※전체 상품 수량 가져오기(공직자에게 30% 판매하는 부분 구현 필요)
※새로운 상품 추가하기
- OrderServiceImpl
- OrderController → API화
※ POST api/v1/order
    주문(랜덤 판매 start)
※ POST api/v1/order/{id}/{quantity}
    해당 id의 재고를 quantity만큼 추가

처음에는 GoodsApp을 만들어 메서드 동작 유무를 확인하였고

API로 만든 후 부터는 포스트맨을 통해 동작을 확인했습니다.

다른 사람들 레포를 봤을떄

- domain, dto, controller, service 등등의 파일구조로 파일 나눠서 작성
- API 만드는 법 배우기
- 자바 클래스들 다루기 + 인텔리제이 사용법 익숙해지기

---

### 1~2번 문제

1. API화 하기 → 성공
2. 랜덤 판매 제대로 동작하게 구축 → 원하는 동작은 아니지만 작동은 함
3. 재고 주문 금액 MAX 100만원 설정(초과시 예외처리) → 필요함

---

### 3번 문제

1. 각 스티커에 프리미엄 정책 추가(Enum으로 관리) -> enum으로 구현
1~7 등급 존재 각 등급별로 물량 공급하고 판매(5,25,125,625,3125개 공급)

---

### 4번

1. 추상화 진행 + 리팩토링 -> Max 금액의 지정 및 공직자 로직 손본 후 진행할 것

---

## 새로 알게된 점

**인텔리제이 한글 깨짐 문제**

Help → Edit Custom Vm Options → idea64.exe.vmoptions 창→ 아래 내용 추가 작성

```java
-Dfile.encoding=UTF-8
-Dconsole.encoding=UTF-8
```

**API 생성하기**

DTO(Data Transfer Object) ⇒ NamwonGoods가 DTO

데이터 전송을 위한 객체로, 클라이언트와 서버 간의 데이터 교환에 사용

보통 외부 시스템과의 상호작용을 위해 사용되며, Entity나 domain 객체와는 다르게 비즈니스 로직이나 데이터베이스와의 상호작용을 포함하지 않는다. 요청과 응답의 데이터 전달에 사용

Controller ⇒ 새로 선언

클라이언트의 요청을 받아 적절한 비즈니스 로직을 호출하여 수행한 후 응답을 반환하는 역할을 한다. API의 라우팅 및 엔드포인트 정의, 클라이언트의 HTTP 요청을 처리하여 비즈니스 로직과 상호작용

Service ⇒ 만들어둠

비즈니스 로직 처리 클래스. 컨트롤러로부터 받은 요청을 처리하고 db와의 상호작용 담당. 비즈니스 로직의 구현이 있는 파일이며 데이터 조작, 유효성, 트랜잭션관리등의 역할을 수행

Repository ⇒ 만들어둠

db와의 상호작용을 담당하는 클래스. db에서 데이터를 가져오거나 저장하는 역할 수행. CRUD 기능을 주로 제공하며, db연결 및 쿼리 작성 처리

Entity

db의 테이블을 모델링한 클래스. 각 entity는 db의 특정 테이블과 매핑, 필드는 테이블의 컬럼과 일치, db의 테이블 구조를 객체 지향적으로 표현하여 애플리케이션에서 사용하는 것

**구현**

Collection의 shuffle 기능 ⇒ 랜덤으로 섞는다

ResponseEntity 클래스 - HttpEntity 상속 받음
**HttpStatus, HttpHeaders, HttpBody를 포함**

반환 타입을 ResponseEntity를 사용해서 일반 객체가 아닌 값으로 받아와 반환 값을 커스텀 할 수 있다.

[ResponseEntity의 사용법 및 유지보수](https://stir.tistory.com/343#google_vignette)

@RequestBody, @ResponseBody ⇒ 비동기 처리를 위한 어노테이션

RequestBody에 해당하는 본문에 해당하는 요청을 같이 보내야함을 며시

@PathVariable ⇒ 경로 변수 어노테이션

{}로 둘러싸인 값을 나타냄, URL에서 변수 값 추출, 경로변수는 default로 값을 가져야하며 없을 경우 404에러 발생

주로 상세 조회, 수정, 삭제 구현에 사용

**enum의 사용**

```java
    // goods 생성 api
    @PostMapping("/goods")
    public ResponseEntity<String> createGoods(@RequestBody NamwonGoods namwonGoods){
        for(GoodsRank rank : GoodsRank.values()){
            BaseGoods goods = new NamwonGoods(namwonGoods.getId(),namwonGoods.getName(),
                    namwonGoods.getPrice(), namwonGoods.getStock(),rank);

            goodsService.createGoods(goods);
        }

        return new ResponseEntity<>("Goods 생성 성공", HttpStatus.CREATED);
    }
```

.values()를 통해 열거형에 등록된 모든 등급 추가 가능

```java
    @PostMapping("/goods")
    public ResponseEntity<String> createGoods(@RequestBody NamwonGoods namwonGoods){
        StringBuilder responseMessage = new StringBuilder("생성된 상품들\n");판매 판매
        for(GoodsRank rank : GoodsRank.values()){
            BaseGoods goods = new NamwonGoods(namwonGoods.getId(),namwonGoods.getName(),
                    namwonGoods.getPrice(), namwonGoods.getStock(),rank);

            goodsService.createGoods(goods);

            responseMessage.append("- ").append(goods.getName()).append(" ")
            .append(rank.name()).append("\n");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage.toString());
    }
    
    // 결과
    생성된 상품들
		- 스티커0 SSR
		- 스티커0 SR
		- 스티커0 S
		- 스티커0 A
		- 스티커0 B
		- 스티커0 C
		- 스티커0 JJ
```

StringBuilder를 통해 반환 메시지 설정

판매 시 JJ만 나오는걸로 봐서 ID가 동일한 객체가 들어와 처음에 들어온 객체를 덮어씌운다고 판단

```java
    // goods 생성 api
    @PostMapping("/goods")
    public ResponseEntity<String> createGoods(@RequestBody NamwonGoods namwonGoods){
        StringBuilder responseMessage = new StringBuilder("생성된 상품들\n");
        Long id = namwonGoods.getId();
        for(GoodsRank rank : GoodsRank.values()){
            BaseGoods goods = new NamwonGoods(id++,namwonGoods.getName(),
                    namwonGoods.getPrice(), namwonGoods.getStock(),rank);
            goodsService.createGoods(goods);

            responseMessage.append("- ").append(goods.getName()).append(" ").append(rank.name()).append("\n");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage.toString());
    }
```

startId를 주어 Id가 겹치는 것을 미리 방지 ⇒ 생성시 Id를 7씩 증가시키면서 넣어줘야함

Id의 중복을 막고자 NamwonGoodsRepository에서 Set으로 관리

```java
package com.econovation.springstudy.goods;

import java.util.*;

public class NamwonGoodsRepository implements GoodsRepository{
    private static Map<Long, BaseGoods> store = new HashMap<>();
    private static Set<Long> usedIds = new HashSet<>();

    @Override
    public void save(BaseGoods goods) {
        Long id = goods.getId();
        if(usedIds.contains(id)){
            throw new IllegalArgumentException("이미 사용된 ID입니다: " + id);
        }
        store.put(goods.getId(),goods);
        usedIds.add(id);
    }

		// 기존 코드들
}

```

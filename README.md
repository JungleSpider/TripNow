# Tripnow
국내 여행객을 대상으로 숙소, 렌터카, 액티비티 상품등을 예약 할 수 있는 웹사이트입니다.

# Description
* 개발 기간: 202 ~ 
* 참여 인원: 4명
* 사용 언어: 
  * JAVA11, SQL, HTML, CSS, JavaScript, JSP/Servlet
* 사용 기술:
  *  JDBC, DOM, Jquery, Ajax, JSTL
* 담당 구현 파트
  -  프로젝트 개발환경 구축, 설계 참여
  -  액티비티 메인 페이지 구현
  -  결제 & 쿠폰 구현
  -  이벤트 & 쿠폰합 구현

# Implementation
* **메인화면**
* 메인화면 사진
  * **메뉴설정, 상품검색 기능**
    * 지역, 날짜, 인원 조건을 설정 후 해당 키워드에 해당되는 상품들을 DB에 조회해서 페이징 처리와 출력.

___
* **상품 카테고리**
 <p align="center"><img src="https://github.com/JungleSpider/TripNow/blob/master/src/main/webapp/file/%EB%A9%94%EC%9D%B8%ED%99%94%EB%A9%B4.PNG?raw=true"/></p>
 <p align="center"><img src="https://github.com/JungleSpider/TripNow/blob/master/src/main/webapp/file/%EB%A6%AC%EC%8A%A4%ED%8A%B8%20%EC%BD%94%EB%93%9C.PNG?raw=true"/></p>

  * PraparedStatement 동적 쿼리문을 이용하여 리스트를 받은 후 출력하고 상품 리스트를 구성합니다.
___
* **상품 상세**
 <p align="center"><img src="https://github.com/JungleSpider/TripNow/blob/master/src/main/webapp/file/%EC%83%81%ED%92%88%20%EC%83%81%EC%84%B8.PNG?raw=true"/></p>

  *  수량 선택, 리뷰 기능
     *  리뷰는 DB조회하여 상품을 구매한 사용자만 리뷰 작성하기 활성화
  *  상품의 위치 확인
     *  'Kakao 지도 API'를 이용한 상품을 이용 할 수 있는 위치 확인
___
* **결제 및 쿠폰적용**
<p align="center"><img src="https://github.com/JungleSpider/TripNow/blob/master/src/main/webapp/file/%EA%B2%B0%EC%A0%9C%20%EC%BF%A0%ED%8F%B0.PNG?raw=true"/></p>

  * 상품 구매 및 쿠폰적용
    * 사용자 USER정보에 담겨있는 이름, 번호, 주소 자동 등록
    * 쿠폰 클릭시 사용자가 가지고 있는 쿠폰 리스트 출력
    * 쿠폰 적용시 Ajax 통신으로 해당 쿠폰이 적용된 가격 출력

___
* **상품등록**
<p align="center"><img src="https://github.com/JungleSpider/TripNow/blob/master/src/main/webapp/file/%EC%83%81%ED%92%88%EB%93%B1%EB%A1%9D.PNG?raw=true"/></p>

  * 상품 등록, 상품상세 설명
    * 파트너 로그인시 상품 등록가능
    * 'Kakao 지도 API'를 이용한 상품 사용 위치 등록
___
* **쿠폰**
<p align="center"><img src="https://github.com/JungleSpider/TripNow/blob/master/src/main/webapp/file/%EC%BF%A0%ED%8F%B0.PNG?raw=true"/></p>

  * 쿠폰 받기, 쿠폰 리스트
    * 쿠폰 받기 클릭시 Ajax 통신으로 해당 쿠폰 중복여부에 따라 알림창 출력
    * 쿠폰 리스트에서 보유중인 쿠폰들과 기간, 할인율 확인
  ___
* **ERD**
<p align="center"><img src="https://github.com/JungleSpider/TripNow/blob/master/src/main/webapp/file/ERD.png?raw=true"/></p>

* **화면 설계**
<p align="center"><img src="https://github.com/JungleSpider/TripNow/blob/master/src/main/webapp/file/%ED%8E%98%EC%9D%B4%EC%A7%80%20%EA%B4%80%EA%B3%84%EB%8F%84%20-%20%ED%99%94%EB%A9%B4%20%EC%88%9C%EC%84%9C.png?raw=true"/></p>
<p align="center"><img src="https://github.com/JungleSpider/TripNow/blob/master/src/main/webapp/file/%ED%8E%98%EC%9D%B4%EC%A7%80%EA%B4%80%EA%B3%84%EB%8F%84%20-%20%ED%99%94%EB%A9%B4%EA%B0%84%20%EB%8D%B0%EC%9D%B4%ED%84%B0%20%EC%9D%B4%EB%8F%99.png?raw=true"/></p>

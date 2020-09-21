## springboot_practice_2

스프링부트 기초 복습 프로젝트 입니다.

***

[목표]
+ 스프링부트 기초 복습

***

[개발 환경]
+ JAVA (11, Zulu Open JDK)
+ Spring Boot (2.3.3)
+ Thymeleaf (2.3.3)
+ Gradle (6.5.1)
+ IntelliJ Community (2020.2.1)

***

[참고 자료]
+ 김영한님 인프런 강의, 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술 [(인프런 바로가기)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard "인프런 바로가기")
+ 구글

***
[실습 참고 사항]
+ H2 Database 를 로컬에 설치한 뒤, H2 를 사용하게 설정해놓고 프로젝트 실행시킬 때 H2 는 꼭 켜둘것. 예외 발생한다.
+ H2 1.4.200 에서 테이블 DROP 이 정상적으로 되지 않는 문제가 있다고 한다.
  + 덕분에 NULL not allowed for column "ID" 오류 메시지가 출력됨. DB 파일 삭제하고 1.4.199 로 바꾸자.

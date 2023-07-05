### 프로젝트 환경설정

git 연동을 위해 git clone 폴더 생성.

내부에 스프링 부트에서 기본제공하는 zip 압축 풀기.

기본 코드 commit

![image](https://github.com/moonyeju/Spring_study/assets/97781412/7529f1ef-62ca-4885-9cdc-bc5ee64736e2)


위 구조로 생성함.

- 빌드하고 실행하기

git clone 폴더인 Spring_study에서 git bash 창 open.

```java
cd spring_info
./gradlew
./gradlew build
//아마 아래거만 해도 되는듯!
cd build
cd libs
ls -arlth
//SNAPSHOT.jar 뜰거임 이거 복사해서!
java -jar <~~SNAPSHOT.jar>
//서버 열림!

//build문제 있을 경우
./gradlew clean build
//완전히 지우고 다시 빌드함
```

- MVC와 템플릿 엔진

RequestParam 를 사용하려면! 

주소에 http://localhost:8080/hello-mvc?name=spring

이런식으로 ? 이름 = < > 이런식으로 값을 넣어줘야 올바르게 동작함!


- 회원 관리 예제

단축키!

→ shift + F6 하면 이름 한번에 바꿀 수 있음.

→ ctrl+alt+v 자동으로 반환코드 작성

→ alt+insert getter setter 만들 때 이용

```java
@AfterEach
    public void afterEach() { //메서드가 실행 끝날 때마다 저장소(공용데이터)를 지움. -> 그래야 오류 없음.
        repository.clearStore();
    }

```

testcase 작성할 때!

이름 join대신 회원가입(한글)로 바꿔도 됨. 

→ 보기 편하려고

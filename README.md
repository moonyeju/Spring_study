# Spring_study
## 스프링 강의 기록

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

package hello.hellospring.controller;

// 커맨드 객체 (DTO)
// 파라미터의 name 을 보고 이 커맨드 객체와 일치하는 필드들이 있으면 setXXX 세터를 이용하여 값을 넣어준다.
public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

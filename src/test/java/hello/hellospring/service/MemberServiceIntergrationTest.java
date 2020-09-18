package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 스프링 컨테이너와 테스트 동시에 실행
@Transactional // 테스트 시작 전에 트랜잭션 시작, 테스트 완료 후에 항상 롤백 (DB테스트할때는 꼭 붙이자!)
public class MemberServiceIntergrationTest {
    // 테스트에서는 굳이 생성자 주입 안해도 상관없다. 편하게 필드 주입으로 하자.
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void join() throws Exception{
        // given
        Member member = new Member();
        member.setName("hello");

        // then
        Long saveId = memberService.join(member);

        // when
        Member one = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(one.getName());
    }

    @Test
    public void duplicate_exception() throws Exception{
        // given
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

        /*
        try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다");
        }
        catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }
         */

        // then

    }
}

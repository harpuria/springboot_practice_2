package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        this.memberRepository = new MemoryMemberRepository();
        this.memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    public void join() {
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
    public void duplicate_exception(){
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

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

    @Test
    public void findMembers() {
    }

    @Test
    public void findOne() {
    }
}
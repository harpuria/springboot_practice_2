package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// 테스트 순서는 무작위이다.
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트 하나가 끝날때마다 호출되는 콜백
    @AfterEach
    public void afterEach(){
        // 테스트 끝날 때마다 객체를 초기화해서 새롭게 테스트할 수 있게 해야 한다.
        repository.clearStore();
    }

    @Test
    public void save(){
        // given (준비 부분 - 변수, Mock 객체 정의 등)
        Member member = new Member();
        member.setName("spring");

        // when (실행 부분 - 테스트 실행)
        repository.save(member);

        // then (검증 부분 - 테스트가 잘 끝났는지 실행을 통해 나온 값으로 검증)
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member); // assertj 에 있는 assertThat() 사용
    }

    @Test
    public void findByName(){
        // given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // when
        Member result = repository.findByName("spring1").get();

        // then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        // given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // when
        List<Member> result = repository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
    }
}
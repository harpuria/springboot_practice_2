package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    private final MemberRepository memberRepository;

    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository) {
        this.dataSource = dataSource;
        this.em = em;
        this.memberRepository = memberRepository;
    }

    // 스프링 빈 등록 (직접 등록)
    @Bean
    public MemberService memberService(){
        //return new MemberService(memberRepository());
        return new MemberService(memberRepository); // JPA
    }

    @Bean
    public MemberRepository memberRepository(){
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

    /*
    AOP 빈은 이렇게 직접 등록하는 것을 권장한다. 단, 이 때 순환참조가 발생하는데 SpringConfig 를 AOP 대상에서 제외시켜주면 된다.
    @Around("execution(* hello.hellospring..*(..)) && !target(hello.hellospring.SpringConfig)")

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
     */
}
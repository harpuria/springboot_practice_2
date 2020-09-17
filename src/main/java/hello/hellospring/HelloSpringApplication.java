package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {

		System.out.println("\\    /\\\n )  ( ')\n(  /  )\n\\(__)|");

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "AAA");
		map.put(2, "BBB");
		map.put(3, "CCC");


		// map 의 value 들을 Collection<T> 타입으로 반환
		System.out.println(map.values());
		System.out.println(map.values().stream()
						.filter(f -> f.equals("AAA")) // f 는 map 의 타입. 즉 여기서는 String 이다. f 에 AAA 가 있는지 확인한 뒤 반환.
						.findAny() // 필터의 조건에 맞는 것을 찾는다
						.get()); // 최종적으로 String 으로 반환

		SpringApplication.run(HelloSpringApplication.class, args);
	}



}

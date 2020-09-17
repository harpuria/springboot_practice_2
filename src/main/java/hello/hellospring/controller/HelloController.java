package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name", "YHH");
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(name="name", defaultValue="spring") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("/hello-string")
    @ResponseBody // 반환할 때 뷰가 아니라 바디에 내용을 직접 넣어서 보낸다. @RestController 를 사용하면 생략해도 된다.
    public String helloString(@RequestParam(name = "name", defaultValue = "spring") String name){
        return "hello " + name;
    }

    @GetMapping("/hello-api")
    @ResponseBody // 객체를 반환하면 JSON 형태로 보낸다. Jackson2 라이브러리에서 알아서 객체 -> JSON 으로 변환해준다
    public Hello Hello(@RequestParam(name="name", defaultValue = "spring") String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

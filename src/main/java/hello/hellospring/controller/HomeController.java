package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        // 단순 문자열
        model.addAttribute("name", "YHH");

        // 맵 형태의 객체
        Map<String, Object> map = new HashMap<>();
        map.put("age", 10);
        map.put("name", "YHH");
        map.put("addr", "sejong");
        model.addAttribute("map", map);

        // 리스트 안에 맵이 들어있는 형태의 객체
        Map<String, Object> map2 = new HashMap<>();
        map2.put("age", 20);
        map2.put("name", "YHM");
        map2.put("addr", "hwaseong");

        Map<String, Object> map3 = new HashMap<>();
        map3.put("age", 30);
        map3.put("name", "KSN");
        map3.put("addr", "gongju");

        List listMap = new ArrayList<>();
        listMap.add(map);
        listMap.add(map2);
        listMap.add(map3);
        model.addAttribute("listMap", listMap);

        return "home";
    }
}

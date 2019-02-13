package cn.reasonwhy.spring.controller;

import cn.reasonwhy.spring.client.TestClient;
import cn.reasonwhy.spring.domain.User;
import cn.reasonwhy.spring.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @Resource
    private TestClient testClient;

    @GetMapping("/hello/user")
    public User user() {
        return testClient.getUser(1);
    }

    @GetMapping("/hello/rds")
    public String helloRds() {
        return helloService.helloRds();
    }

    @GetMapping("/hello/drds")
    public String helloDrds() {
        return helloService.helloDrds();
    }
}

package cn.reasonwhy.spring.client;

import cn.reasonwhy.spring.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "test", url = "https://www.baidu.com")
public interface TestClient {
    @GetMapping("/user")
    User getUser(@RequestParam(value = "userId") Integer userId);
}


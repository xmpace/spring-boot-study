package cn.reasonwhy.spring.client;

import cn.reasonwhy.spring.domain.User;
import com.netflix.hystrix.HystrixCommand;
import org.bouncycastle.util.test.Test;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.FallbackCommand;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "test", url = "https://www.baidu.com", fallback = TestClient.TestClientFallback.class)
public interface TestClient {
    @GetMapping("/user")
    User getUser(@RequestParam(value = "userId") Integer userId);

    @GetMapping("/asd")
    HystrixCommand<String> getUserCommand(@RequestParam(value = "userId") Integer userId);

    @Component
    class TestClientFallback implements TestClient {
        @Override
        public User getUser(Integer userId) {
            return null;
        }

        @Override
        public HystrixCommand<String> getUserCommand(Integer userId) {
            return new FallbackCommand<>("your fallback value");
        }
    }
}

